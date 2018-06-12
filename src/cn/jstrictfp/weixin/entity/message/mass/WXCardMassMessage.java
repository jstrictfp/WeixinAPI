package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信卡券消息
 * 
 * @author Administrator
 *
 */
public class WXCardMassMessage extends MassMessage{

	public Map<String,String> wxcard;
	
	public WXCardMassMessage(String cardId){
		super("wxcard");
		this.wxcard=new HashMap<String,String>();
		this.wxcard.put("card_id", cardId);
	}

	public Map<String, String> getWxcard() {
		return wxcard;
	}

	public void setWxcard(Map<String, String> wxcard) {
		this.wxcard = wxcard;
	}
	
}
