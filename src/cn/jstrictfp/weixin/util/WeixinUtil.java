package cn.jstrictfp.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取配置文件 wechat.properties
 * 
 * @author Administrator
 * 
 */
public class WeixinUtil {
	
	private static Logger logger = Logger.getLogger(WeixinUtil.class);
	
	private static final String WEIXIN_FILE = "/wechat.properties";//微信公众号配置文件地址
	
	private static WeixinUtil wei = new WeixinUtil();
	
	private String url;//公众号配置url
	private String token;//公众号token
	private String encodingAESKey;// 加密方式
	private String appid;//appid
	private String appSecret;//公众号秘钥
	private String tokenServer;//自定义token服务器

	private WeixinUtil() {
		Properties p = new Properties();
		InputStream inStream = this.getClass().getResourceAsStream(WEIXIN_FILE);
		if (inStream == null) {
			logger.error("找不到wechat.properties文件");
			return;
		}
		try {
			p.load(inStream);
			this.url = p.getProperty("wechat.url").trim();
			this.encodingAESKey = p.getProperty("wechat.encodingaeskey").trim();
			this.token = p.getProperty("wechat.token").trim();
			this.appid = p.getProperty("wechat.appid").trim();
			this.appSecret = p.getProperty("wechat.appsecret").trim();
			this.tokenServer = p.getProperty("wechat.tokenServer").trim();
			inStream.close();
		} catch (IOException e) {
			logger.error("找不到wechat.properties文件");
			e.printStackTrace();
		}
		logger.info("wechat4j.properties 加载成功");
	}

	public static WeixinUtil instance() {
		return wei;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getTokenServer() {
		return tokenServer;
	}

	public void setTokenServer(String tokenServer) {
		this.tokenServer = tokenServer;
	}

	public static void main(String[] args) {
		System.out.println(WeixinUtil.instance().getAppid());
	}
	
}
