package cn.jstrictfp.weixin.entity.user;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 生成短链接返回信息
 * @author Administrator
 *
 */
public class ShortUrlResult extends Result {

	//生成短链接
	private String short_url;

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	
}
