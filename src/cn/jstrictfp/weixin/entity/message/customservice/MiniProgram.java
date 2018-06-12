package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 小程序
 * @author Administrator
 *
 */
public class MiniProgram {

	private String title;
	//小程序的appid，要求小程序的appid需要与公众号有关联关系
	private String appid;
	//小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
	private String pagepath;
	//媒体ID
	private String thumb_media_id;
	
	public MiniProgram(String title, String appid, String pagepath,
			String thumb_media_id) {
		super();
		this.title = title;
		this.appid = appid;
		this.pagepath = pagepath;
		this.thumb_media_id = thumb_media_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	
}
