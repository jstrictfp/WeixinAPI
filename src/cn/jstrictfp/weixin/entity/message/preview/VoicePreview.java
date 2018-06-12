package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 语音消息预览
 * @author Administrator
 *
 */
public class VoicePreview extends Preview{

	private Map<String,String> voice;

	/**
	 * @param mediaId 此处的media_id与根据分组群发中的media_id相同
	 */
	public VoicePreview(String mediaId) {
		super();
		super.setMsgtype("voice");
		this.voice = new HashMap<String,String>();
		this.voice.put("media_id",mediaId);
	}

	public Map<String, String> getVoice() {
		return voice;
	}

	public void setVoice(Map<String, String> voice) {
		this.voice = voice;
	}
	 
}
