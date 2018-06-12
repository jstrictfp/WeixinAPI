package cn.jstrictfp.weixin.entity.message.subscribemsg;

import java.util.Map;

import cn.jstrictfp.weixin.entity.message.template.TemplateItem;

/**
 * 订阅模板消息
 * @author Administrator
 *
 */
public class SubscribeTemplate {
	
	//填接收消息的用户openid
	private String touser;
	//订阅消息模板ID
	private String template_id;
	//点击消息跳转的链接，需要有ICP备案
	private String url;
	//订阅场景值
	private int scene;
	//消息标题，15字以内
	private String title;
	//消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
	private Map<String,TemplateItem> data;
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getScene() {
		return scene;
	}
	public void setScene(int scene) {
		this.scene = scene;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, TemplateItem> getData() {
		return data;
	}
	public void setData(Map<String, TemplateItem> data) {
		this.data = data;
	}
	
}
