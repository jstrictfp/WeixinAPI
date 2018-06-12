package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 语音消息
 * @author Administrator
 *
 */
public class VoiceMassMessage extends MassMessage{

	private Map<String,String> voice;
	
	/**
	 * 此处media_id需通过基础支持中的上传下载多媒体文件来得到
	 * @param mediaId
	 */
	public VoiceMassMessage(String mediaId){
		super("voice");
		this.voice=new HashMap<String,String>();
		this.voice.put("media_id", mediaId);
	}

	public Map<String, String> getVoice() {
		return voice;
	}

	public void setVoice(Map<String, String> voice) {
		this.voice = voice;
	}
	
}
