package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 图片消息
 * 
 * @author Administrator
 *
 */
public class ImageMessage extends Message{
	
	private Image image;

	public ImageMessage(String touser) {
		super(touser, "image");
	}
	
	public ImageMessage(String touser,String mediaId) {
		this(touser);
		this.image=new Image();
		this.image.setMedia_id(mediaId);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public static class Image{
		
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
	
}
