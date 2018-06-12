package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.user.ShortUrlResult;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 短连接Api
 * @author Administrator
 *
 */
public class ShortUrlApi extends Api {

	private static Logger log=LoggerFactory.getLogger(ShortUrlApi.class);
	//长链接转短链接接口
	private static final String SHORT_URL="https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	
	/**
	 * 长链接转短链接
	 * @param accessToken 接口调用凭据
	 * @param url 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
	 * @return
	 */
	public static ShortUrlResult shortUrl(String accessToken,String url){
		String reqUrl = SHORT_URL.replace(token(), accessToken);
		String json = "{\"action\":\"long2short\",\"long_url\":\""+url+"\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, "POST",json);
		ShortUrlResult result = (ShortUrlResult) JSONObject.toBean(jsonObject,ShortUrlResult.class);
		if(result.isSuccess()){
			log.info("短链接获取成功");
			return result;
		}
		log.error("短链接获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	
}
