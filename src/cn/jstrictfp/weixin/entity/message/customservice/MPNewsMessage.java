package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 图文消息
 * @author Administrator
 *
 */
public class MPNewsMessage extends Message {

	public MPNewsMessage(String touser) {
		super(touser,"mpnews");
	}
	
	public MPNewsMessage(String touser,String mediaId){
		this(touser);
		this.mpnews=new MPNews();
		this.mpnews.setMedia_id(mediaId);
	}
	
	private MPNews mpnews;

	public MPNews getMpnews() {
		return mpnews;
	}

	public void setMpnews(MPNews mpnews) {
		this.mpnews = mpnews;
	}

	public static class MPNews{
		
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
}
