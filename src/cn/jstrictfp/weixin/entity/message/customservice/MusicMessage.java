package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 音乐消息
 * @author Administrator
 *
 */
public class MusicMessage extends Message {

	public MusicMessage(String touser) {
		super(touser, "music");
	}

	public MusicMessage(String touser,Music music){
		this(touser);
		this.music=music;
	}
	
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
	public static class Music{
		
		private String title;
		private String description;
		private String musicurl;
		private String hqmusicurl;
		private String thumb_media_id;
		
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
		public String getMusicurl() {
			return musicurl;
		}
		public void setMusicurl(String musicurl) {
			this.musicurl = musicurl;
		}
		public String getHqmusicurl() {
			return hqmusicurl;
		}
		public void setHqmusicurl(String hqmusicurl) {
			this.hqmusicurl = hqmusicurl;
		}
		public String getThumb_media_id() {
			return thumb_media_id;
		}
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}
		
	}

}
