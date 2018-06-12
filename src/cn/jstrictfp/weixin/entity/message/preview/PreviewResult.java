package cn.jstrictfp.weixin.entity.message.preview;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 预览及群发消息返回信息
 * 
 * @author Administrator
 *
 */
public class PreviewResult extends Result{
	
	//群发消息后返回的消息id
	private int msg_id;
	//消息发送后的状态，SEND_SUCCESS表示发送成功
	private String msg_status;

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}
	
}
