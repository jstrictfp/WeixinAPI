package cn.jstrictfp.weixin.entity.message.subscribemsg;

/**
 * 订阅模板消息
 * @author Administrator
 *
 */
public class Subscribe {
	
	//订阅消息模板ID
	private String templateId;
	//授权后重定向的回调地址，请使用UrlEncode对链接进行处理。要求redirect_url的域名要跟登记的业务域名一致
	private String redirectUrl;
	//0-10000的整形值，用来标识订阅场景值
	private int scene;
	//可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
	private String reserved;
	
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public int getScene() {
		return scene;
	}
	public void setScene(int scene) {
		this.scene = scene;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
}
