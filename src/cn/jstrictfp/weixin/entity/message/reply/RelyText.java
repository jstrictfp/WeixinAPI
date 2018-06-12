package cn.jstrictfp.weixin.entity.message.reply;

/**
 * 回复文本消息
 * @author Administrator
 *
 */
public class RelyText extends Rely{
	
	//文本消息内容
	private String content;
	
	public RelyText(String toUserName, String fromUserName, String msgType,
			String content) {
		super(toUserName, fromUserName, "text");
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String subXML() {
		StringBuilder str=new StringBuilder();
		str.append("<Content><![CDATA["+content==null?"":content+"]]></Content>");
		return str.toString();
	}

}
