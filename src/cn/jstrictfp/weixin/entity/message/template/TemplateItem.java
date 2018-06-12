package cn.jstrictfp.weixin.entity.message.template;

/**
 * 模板消息内容
 * @author Administrator
 *
 */
public class TemplateItem {
	//消息内容
	private String value;
	//模板内容字体颜色，不填默认为黑色
	private String color;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
