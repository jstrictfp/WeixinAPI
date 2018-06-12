package cn.jstrictfp.weixin.entity.message.reply;

/**
 * 回复消息
 * @author Administrator
 *
 */
public abstract class Rely {

	//开发者微信号
	private String toUserName;
	//发送方微信号（一个OpenID）
	private String fromUserName;
	//消息创建时间
	private long createTime;
	//消息类型 text|voice|video|image|news|music
	private String msgType;

	public Rely(String toUserName, String fromUserName, String msgType) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.msgType = msgType;
	}
	
	/**
	 * 子类自定义XML
	 * @return XML
	 */
	public abstract String subXML();
	
	public String toXML(){
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA["+toUserName+"]]></ToUserName>");
		sb.append("<FromUserName><![CDATA["+fromUserName+"]]></FromUserName>");
		sb.append("<CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>");
		sb.append("<MsgType><![CDATA["+msgType+"]]></MsgType>");
		sb.append(subXML());
		sb.append("</xml>");
		return sb.toString();
	}
}
