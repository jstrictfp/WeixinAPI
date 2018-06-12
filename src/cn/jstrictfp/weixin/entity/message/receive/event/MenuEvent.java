package cn.jstrictfp.weixin.entity.message.receive.event;

/**
 * 自定义菜单事件
 * @author Administrator
 *
 */
public class MenuEvent {
	
	//开发者微信号
	private String ToUserName;
	//发送方微信号（一个OpenID）
	private String FromUserName;
	//消息创建时间
	private long CreateTime;
	//消息类型 event
	private String MsgType;
	//事件类型，点击菜单跳转链接时为 VIEW,点击菜单拉取消息时为CLICK
	private String Event;	
	//事件KEY值，点击菜单跳转链接时为跳转的URL,点击菜单拉取消息时与自定义菜单接口中KEY值对应
	private String EventKey;
	
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
	
}
