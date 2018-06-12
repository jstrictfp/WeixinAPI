package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡券消息预览
 * 
 * @author Administrator
 *
 */
public class WXCardPreview extends Preview{

	private Map<String,Object> wxcard;
	
	public WXCardPreview(String card_id,Map<String,String> card_text){
		super();
		super.setMsgtype("wxcard");
		this.wxcard=new HashMap<String,Object>();
		this.wxcard.put("card_id", card_id);
		this.wxcard.put("card_text",card_text);
	}

	public Map<String, Object> getWxcard() {
		return wxcard;
	}

	public void setWxcard(Map<String, Object> wxcard) {
		this.wxcard = wxcard;
	}
	
}
