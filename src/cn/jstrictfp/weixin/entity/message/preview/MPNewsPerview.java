package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 图文消息预览
 * @author Administrator
 *
 */
public class MPNewsPerview extends Preview{

	private Map<String,String> mpnews;
	
	/**
	 * @param mediaId 此处的media_id与根据分组群发中的media_id相同
	 */
	public MPNewsPerview(String mediaId) {
		super();
		this.mpnews = new HashMap<>();
		this.mpnews.put("media_id", mediaId);
		super.setMsgtype("mpnews");
	}

	public Map<String, String> getMpnews() {
		return mpnews;
	}

	public void setMpnews(Map<String, String> mpnews) {
		this.mpnews = mpnews;
	}
	
}
