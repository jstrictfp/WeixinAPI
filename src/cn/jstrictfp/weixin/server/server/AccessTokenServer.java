package cn.jstrictfp.weixin.server.server;

import cn.jstrictfp.weixin.util.WeixinUtil;

/**
 * 适配器
 * @author ChengNing
 * @date   2015年1月30日
 */
public class AccessTokenServer extends AbsServer implements TokenServer {
	
	@Override
	protected String getCustomerServerClass() {
		return WeixinUtil.instance().getTokenServer();
	}

	public String token(){
		return super.token();
	}

}
