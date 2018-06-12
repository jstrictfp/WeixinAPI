package cn.jstrictfp.weixin.entity.qr;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 带参数二维码信息
 * @author Administrator
 *
 */
public class QRCodeResult extends Result {

	private String ticket;	//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	private int expire_seconds;	//该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	private String url;	//二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
