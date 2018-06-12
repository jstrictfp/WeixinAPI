package cn.jstrictfp.weixin.server.entity;

import org.apache.log4j.Logger;

import cn.jstrictfp.weixin.server.listener.TokenProxy;

/**
 * 微信js ticket
 * @author Administrator
 *
 */
public class JsApiTicket extends Token {

	private static Logger logger = Logger.getLogger(JsApiTicket.class);
	
	private static final String GET_TICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	private static final String JS_API_TICKET="ticket";
	
	private static final String EXPIRES_IN="expires_in";
	
	@Override
	protected String tokenName() {
		
		return JS_API_TICKET;
	}

	@Override
	protected String expiresInName() {
		
		return EXPIRES_IN;
	}

	@Override
	protected String tokenUrl() {
		String accessToken = TokenProxy.accessToken();
		String url=GET_TICKET.replace("ACCESS_TOKEN", accessToken);
		
		return url;
	}

}
