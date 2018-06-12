package cn.jstrictfp.weixin.entity.media;

/**
 * 上传客服消息中所需的视频文件
 * 
 * @author Administrator
 *
 */
public class UploadVideo {
	
	//此处的媒体Id此处media_id需通过基础支持中的上传下载多媒体文件来得到
	private String media_id;
	//标题
	private String title;
	//消息描述
	private String description;
	
	public UploadVideo(String media_id, String title, String description) {
		super();
		this.media_id = media_id;
		this.title = title;
		this.description = description;
	}
	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
