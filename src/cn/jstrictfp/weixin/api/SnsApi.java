package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.sns.SNSTokenResult;
import cn.jstrictfp.weixin.entity.user.UserResult;
import cn.jstrictfp.weixin.util.CommonUtil;
import cn.jstrictfp.weixin.util.HttpUtil;
import cn.jstrictfp.weixin.util.WeixinUtil;

/**
 * 网页授权api
 * @author Administrator
 *
 */
public class SnsApi extends Api {

	private static Logger logger=LoggerFactory.getLogger(SnsApi.class);
	//微信网页授权链接
	private static final String AUTHORIZE="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//通过code换取access_token
	private static final String GET_TOKEN_CODE="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新access_token 
	private static final String REFRESH_TOKEN="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//通过网页授权获取用户信息
	private static final String USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//判断access_token 是否有效
	private static final String AUTH="https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
	/**
	 *  检验授权凭证（access_token）是否有效
	 * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid 用户的唯一标识
	 * @return
	 */
	public static Result getUserInfo(String access_token,String openid){
		String reqUrl=AUTH.replace(token(), access_token).replace("OPENID", openid);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), null);
		UserResult result = (UserResult) JSONObject.toBean(jsonObject,UserResult.class);
		if(result.isSuccess()){
			logger.info("access_token有效");
			return result;
		}
		logger.error("access_token失效或参数错误，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 *  通过网页授权获取用户信息
	 * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid 用户的唯一标识
	 * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public static UserResult getUserInfo(String access_token,String openid,String lang){
		String reqUrl=USERINFO.replace(token(), access_token).replace("OPENID", openid).replace("zh_CN", lang);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), null);
		UserResult result = (UserResult) JSONObject.toBean(jsonObject, UserResult.class);
		if(result.isSuccess()){
			logger.info("网页授权用户信息获取成功");
			return result;
		}
		logger.error("网页授权用户信息获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 刷新access_token 
	 * @param refreshToken 获取access_token时取到的refresh_token参数  
	 * @return
	 */
	public static SNSTokenResult refreshToken(String refreshToken){
		String reqUrl=REFRESH_TOKEN.replace("REFRESH_TOKEN", refreshToken).replace("APPID", WeixinUtil.instance().getAppid());
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), null);
		SNSTokenResult result = (SNSTokenResult) JSONObject.toBean(jsonObject, SNSTokenResult.class);
		if(result.isSuccess()){
			logger.info("网页access_token刷新成功");
			return result;
		}
		logger.error("网页access_token获取刷新失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 通过code换取网页授权access_token
	 * @param code 用户授权后的凭据
	 * @return
	 */
	public static SNSTokenResult getSNSToken(String code){
		String reqUrl=GET_TOKEN_CODE.replace("CODE", code).replace("APPID", WeixinUtil.instance().getAppid()).replace("SECRET",  WeixinUtil.instance().getAppSecret());
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), null);
		SNSTokenResult result = (SNSTokenResult) JSONObject.toBean(jsonObject, SNSTokenResult.class);
		if(result.isSuccess()){
			logger.info("网页access_token获取成功");
			return result;
		}
		logger.error("网页access_token获取发送失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取微信网页授权链接
	 * @param url 回调链接
	 * @param state 填写a-zA-Z0-9的参数值，最多128字节
	 * @param i 应用授权作用域，填0或1；为0时 （不弹出授权页面，直接跳转，只能获取用户openid），为1时 （弹出授权页面，可通过openid拿到昵称、性别、所在地。)
	 * @return
	 */
	public static String getSnsUrl(String url,String state,int i){
    	String urlEncode=CommonUtil.urlEncodeUTF8(url);
    	System.out.println("utf8_url:"+urlEncode);
        AUTHORIZE.replace("APPID", WeixinUtil.instance().getAppid()).replace("REDIRECT_URI", urlEncode).replace("STATE", state);
        switch(i){
             case 0:
            	 AUTHORIZE.replace("SCOPE", "snsapi_base");
            	 break;
             case 1:
            	 AUTHORIZE.replace("SCOPE", "snsapi_userinfo");
            	 break;
             default:
            	 
            	 break;
        }
        System.out.println("网页授权链接为:"+AUTHORIZE);
        
        return AUTHORIZE;
	}
	
	public static void main(String[] args) {
		System.out.println(getSnsUrl("http://","1123",1));
	}
}
