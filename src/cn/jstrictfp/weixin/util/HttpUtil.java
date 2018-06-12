package cn.jstrictfp.weixin.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 用于处理http请求
 * @author Administrator
 *
 */
public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	/**
	 * 发起普通接口的https请求
	 * @param requestUrl 请求链接
	 * @param requestMethod 请求方式：get|post
	 * @param outputStr json字符串
	 * @return
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        try {
        	//建立https连接
            HttpsURLConnection httpsUrlConn = getHttps(requestUrl);  
            // 设置请求方式（GET/POST）   
            httpsUrlConn.setRequestMethod(requestMethod);  
            if ("GET".equalsIgnoreCase(requestMethod)){
            	httpsUrlConn.connect(); 
            }
            // 当有数据需要提交时   
            if (null != outputStr) {  
                OutputStream outputStream = httpsUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码   
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  	  
            // 将返回的输入流转换成字符串   
            InputStream inputStream = httpsUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            String str = null; 
            StringBuffer buffer=new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源   
            inputStream.close();  
            inputStream = null;  
            httpsUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
        	logger.error("连接超时：{}",ce);  
        } catch (Exception e) {  
        	logger.error("https 请求错误:{}", e);  
        }  
        return jsonObject;  
    }

	/**
     * 发起文件上传的https请求
     *  
     * @param requestUrl  微信上传素材的接口url
     * @param file    要上传的文件
     * @return String  上传成功后，微信服务器返回的消息
     */
    public static JSONObject httpsRequest(String requestUrl, File file) {  
    	JSONObject jsonObject = null;
        try{
        	//建立https连接
            HttpsURLConnection httpsUrlConn = getHttps(requestUrl);
            //1.2设置请求头信息
            httpsUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpsUrlConn.setRequestProperty("Charset", "UTF-8");
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpsUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);
            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpsUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);
            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();
            
            //5.将微信服务器返回的输入流转换成字符串  
            InputStream inputStream = httpsUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            
            StringBuffer buffer = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpsUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } 
        return jsonObject;
    }

    /** 
     * 发起http请求获取返回结果 
     *  
     * @param requestUrl 请求地址 
     * @return 
     */  
    public static JSONObject httpRequest(String requestUrl,String requestMethod,File file) {
    	JSONObject jsonObject = null;
        try{
        	//建立http连接
        	URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoOutput(false);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.connect();
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);
            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);
            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();
            //5.将微信服务器返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            StringBuffer buffer = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } 
        return jsonObject;
    }
    
    /**
     * 下载图片
     * @param imageUrl 图片url
     * @param filePath 保存路径
     * @param fileName 保存名称
     */
    public static void downImage(String imageUrl,String filePath,String fileName){
    	//建立连接
        HttpsURLConnection httpUrlConn = getHttps(imageUrl);    
        // 设置请求方式（GET）
        try {
			httpUrlConn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}  
        // 将微信服务器返回的输入流写入文件
        BufferedInputStream bis=null;
		try {
			bis = new BufferedInputStream(httpUrlConn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if (!filePath.endsWith("/")) { 
			filePath+="/";
        }
		File sf=new File(filePath); 
        if(!sf.exists()){
        	//如果不存在就创建一个
            sf.mkdirs();  
        } 
        //将ticket作为文件名
        filePath=filePath+fileName+".jpg";
        FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        byte[] buf=new byte[8096];
        int size=0;
        try {
			while ((size= bis.read(buf)) != -1) {  
			    fos.write(buf,0,size); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//关闭输入流和文件流
			try {
				bis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 
        httpUrlConn.disconnect();
        logger.info("图片已保存到"+filePath);
    }
    
    /**
	 * 建立https连接
	 * @param requestUrl 请求链接
	 * @return https连接
	 */
	private static HttpsURLConnection getHttps(String requestUrl){
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化   
		TrustManager[] tm = { new MyX509TrustManager() };  
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}  
		try {
			sslContext.init(null, tm, new java.security.SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}  
		// 从上述SSLContext对象中得到SSLSocketFactory对象   
		SSLSocketFactory ssf = sslContext.getSocketFactory();  
		URL url = null;
		try {
			url = new URL(requestUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}  
		HttpsURLConnection httpsUrlConn = null;
		try {
			httpsUrlConn = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		httpsUrlConn.setSSLSocketFactory(ssf);  
		httpsUrlConn.setDoOutput(true);  
		httpsUrlConn.setDoInput(true);  
		httpsUrlConn.setUseCaches(false);
		
		return httpsUrlConn;
	} 

}
