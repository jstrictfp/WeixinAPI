package cn.jstrictfp.weixin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用工具类
 * @author Administrator
 *
 */
public class CommonUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	
	/**
     * URL编码（utf-8）
     * 
     * @param source 
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
        	logger.error("编码异常");
            e.printStackTrace();
        }
        return result;
    }
    
}
