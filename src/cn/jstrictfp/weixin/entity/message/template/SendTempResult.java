package cn.jstrictfp.weixin.entity.message.template;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 发送模板消息返回结果
 * @author Administrator
 *
 */
public class SendTempResult extends Result {
    
	//模板消息Id
	private int msgid;

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	
	
}
