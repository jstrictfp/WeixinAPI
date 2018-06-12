package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 视频消息预览
 * 
 * @author Administrator
 *
 */
public class VideoPreview extends Preview{

	private Map<String,String> video;
	
	/**
	 * @param mediaId 此处的media_id与根据分组群发中的media_id相同
	 */
	public VideoPreview(String mediaId){
		super();
		super.setMsgtype("video");
		this.video=new HashMap<String,String>();
		this.video.put("media_id",mediaId);
	}

	public Map<String, String> getVideo() {
		return video;
	}

	public void setVideo(Map<String, String> video) {
		this.video = video;
	}
	
}
