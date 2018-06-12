package cn.jstrictfp.weixin.entity.message.mass;

import java.util.Set;

/**
 * 群发消息对象
 * @author Administrator
 *
 */
public class MassMessage {

	private Filter filter;
	
	private String msgtype;
	
	private Set<String> touser;//用于指定用户
	
	/**
	 * 当 send_ignore_reprint 参数设置为1时，文章被判定为转载时，且原创文允许转载时，将继续进行群发操作。
	 * 为0时，文章被判定为转载时，将停止群发操作。send_ignore_reprint 默认为0。
	 */
	private int send_ignore_reprint=0;
	//避免重复发送  如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
	private String clientmsgid;
	
	/**
	 * @param filter
	 * @param msgtype
	 */
	public MassMessage(String msgtype) {
		super();
		this.msgtype = msgtype;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public int getSend_ignore_reprint() {
		return send_ignore_reprint;
	}

	public void setSend_ignore_reprint(int send_ignore_reprint) {
		this.send_ignore_reprint = send_ignore_reprint;
	}

	public Set<String> getTouser() {
		return touser;
	}

	public void setTouser(Set<String> touser) {
		this.touser = touser;
	}

	public String getClientmsgid() {
		return clientmsgid;
	}

	public void setClientmsgid(String clientmsgid) {
		this.clientmsgid = clientmsgid;
	}
	
}
