package cn.jstrictfp.weixin.server.entity;

import org.apache.log4j.Logger;

import cn.jstrictfp.weixin.util.WeixinUtil;

/**
 * 公众号accessToken
 * @author Administrator
 *
 */
public class AccessToken extends Token {
	
	private static Logger logger = Logger.getLogger(AccessToken.class);
	
	private static final String TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	private static final String ACCESS_TOKEN="access_token";
	
	private static final String EXPIRES_IN="expires_in";

	@Override
	protected String tokenName() {
		
		return ACCESS_TOKEN;
	}

	@Override
	protected String tokenUrl() {
		String appId=WeixinUtil.instance().getAppid();
		String appSecret=WeixinUtil.instance().getAppSecret();
		String url=TOKEN.replace("APPID", appId).replace("APPSECRET", appSecret);
		
		return url;
	}

	@Override
	protected String expiresInName() {
		
		return EXPIRES_IN;
	}

}
