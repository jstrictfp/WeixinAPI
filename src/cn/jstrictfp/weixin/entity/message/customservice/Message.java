package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 公众号发送客服消息
 * 
 * @author Administrator
 *
 */
public class Message {
	
	//用户openid
	private String touser;
	//消息类型 text|image|voice|video|music|news|mpnews|wxcard|miniprogram
	private String msgtype;
	
	public Message(String touser, String msgtype) {
		super();
		this.touser = touser;
		this.msgtype = msgtype;
	}
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}
