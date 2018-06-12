package cn.jstrictfp.weixin.entity.message.preview;

/**
 * 群发预览
 * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，
 * 增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
 * @author Administrator
 *
 */
public class Preview {

	//用户openid  touser和towxname 两者二选一即可
	private String touser;
	//用户微信号   towxname和touser同时赋值时，以towxname优先
	private String towxname;
	//消息类型
	private String msgtype;
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTowxname() {
		return towxname;
	}
	public void setTowxname(String towxname) {
		this.towxname = towxname;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
}
