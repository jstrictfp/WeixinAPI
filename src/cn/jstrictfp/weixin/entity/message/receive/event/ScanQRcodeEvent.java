package cn.jstrictfp.weixin.entity.message.receive.event;

/**
 * 扫描二维码事件
 * @author Administrator
 *
 */
public class ScanQRcodeEvent{
	
	//开发者微信号
	private String ToUserName;
	//发送方微信号（一个OpenID）
	private String FromUserName;
	//消息创建时间
	private long CreateTime;
	//消息类型 event
	private String MsgType;
	//事件类型，用户关注时：subscribe 用户未关注时：SCAN
	private String Event;	
	//事件KEY值，用户已关注时：qrscene_为前缀，后面为二维码的参数值  用户未关注时：是一个32位无符号整数，即创建二维码时的二维码scene_id
	private String EventKey;
	//二维码的ticket，可用来换取二维码图片
	private String Ticket;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	
	
}
