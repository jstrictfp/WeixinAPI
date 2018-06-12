package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 视频消息
 * 
 * @author Administrator
 *
 */
public class VideoMessage extends Message {

	public VideoMessage(String touser) {
		super(touser, "video");
	}
	
	public VideoMessage(String touser,Video video){
		this(touser);
		this.video=video;
	}
	
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	public static class Video{
		//视频消息的媒体ID
		private String media_id;
		//缩略图/小程序卡片图片的媒体ID
		private String thumb_media_id;
		//视频消息的标题
		private String title;
		//视频消息的描述
		private String description;
		
		public Video(String media_id, String thumb_media_id, String title,
				String description) {
			super();
			this.media_id = media_id;
			this.thumb_media_id = thumb_media_id;
			this.title = title;
			this.description = description;
		}
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		public String getThumb_media_id() {
			return thumb_media_id;
		}
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
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

}
