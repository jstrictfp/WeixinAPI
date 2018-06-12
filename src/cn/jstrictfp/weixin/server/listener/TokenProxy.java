package cn.jstrictfp.weixin.server.listener;

import cn.jstrictfp.weixin.server.server.AccessTokenServer;
import cn.jstrictfp.weixin.server.server.TokenServer;

/**
 * token，ticket获取代理
 * 
 * @author Administrator
 *
 */
public class TokenProxy {
	
	/**
	 * 通过代理得到accessToken的串
	 */
	public static String accessToken(){
		TokenServer accessTokenServer = new AccessTokenServer();
		return accessTokenServer.token();
	}
	
}
