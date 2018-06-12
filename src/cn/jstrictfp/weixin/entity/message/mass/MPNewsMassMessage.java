package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 图文消息
 * @author Administrator
 *
 */
public class MPNewsMassMessage extends MassMessage{
	
	private Map<String,String> mpnews;
	
	/**
	 * @param mediaId 这里的mediaId要通过cn.jstrictfp.weixin.api.MassApi.uploadNews来得到
	 */
	public MPNewsMassMessage(String mediaId) {
		super("mpnews");
		this.mpnews = new HashMap<String,String>();
		this.mpnews.put("media_id", mediaId);
	}

	public Map<String, String> getMpnews() {
		return mpnews;
	}

	public void setMpnews(Map<String, String> mpnews) {
		this.mpnews = mpnews;
	}

}
