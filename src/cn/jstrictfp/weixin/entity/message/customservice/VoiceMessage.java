package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 语音消息
 * 
 * @author Administrator
 *
 */
public class VoiceMessage extends Message{

	public VoiceMessage(String touser) {
		super(touser, "voice");
	}
	
	public VoiceMessage(String touser,String mediaId){
		this(touser);
		this.voice=new Voice();
		this.voice.setMedia_id(mediaId);
	}

	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	public static class Voice{
		
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
	
}
