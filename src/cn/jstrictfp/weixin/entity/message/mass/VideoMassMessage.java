package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 视频消息
 * @author Administrator
 *
 */
public class VideoMassMessage extends MassMessage{

	private Map<String,String> mpvideo;

	/**
	 * 此处的mediaId通过cn.jstrictfp.weixin.api.MassApi.uploadVideo 获得
	 * @param mediaId
	 */
	public VideoMassMessage(String mediaId) {
		super("mpvideo");
		this.mpvideo = new HashMap<String,String>();
		this.mpvideo.put("media_id", mediaId);
	}

	public Map<String, String> getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(Map<String, String> mpvideo) {
		this.mpvideo = mpvideo;
	}
	
}
