package cn.jstrictfp.weixin.entity.menu.config;

import java.util.List;

/**
 * 自定义菜单配置
 * @author Administrator
 *
 */
public class Button {

	private String name;
	private String type; //click|view|news_info|img|text|voice|video
	private String key;  //使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；
	private String url;  //view：保存链接到url
	private String value;//Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； ，同时保存mediaID到value；
	private NewsInfo news_info;// News：保存图文消息到news_info
	private List<Button> list;
	private Button sub_button;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Button> getList() {
		return list;
	}

	public void setList(List<Button> list) {
		this.list = list;
	}

	public Button getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button sub_button) {
		this.sub_button = sub_button;
	}

	public NewsInfo getNews_info() {
		return news_info;
	}

	public void setNews_info(NewsInfo news_info) {
		this.news_info = news_info;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
