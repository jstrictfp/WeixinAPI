package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 微信卡券消息
 * @author Administrator
 *
 */
public class WXCardMessage extends Message{

	public WXCardMessage(String touser) {
		super(touser, "wxcard");
	}
	
	public WXCardMessage(String touser,String cardId){
		this(touser);
		this.wxcard=new WXCard();
		this.wxcard.setCard_id(cardId);
	}
	
	private WXCard wxcard;

	public WXCard getWxcard() {
		return wxcard;
	}

	public void setWxcard(WXCard wxcard) {
		this.wxcard = wxcard;
	}

	public static class WXCard{
		
		private String card_id;

		public String getCard_id() {
			return card_id;
		}

		public void setCard_id(String card_id) {
			this.card_id = card_id;
		}
		
	}
	
}
