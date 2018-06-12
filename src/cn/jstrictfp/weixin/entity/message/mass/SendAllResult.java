package cn.jstrictfp.weixin.entity.message.mass;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 群发返回对象
 * @author Administrator
 *
 */
public class SendAllResult extends Result{
	
	//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息为news
	private String type;
	//消息发送任务的ID
	private int msg_id;
	//消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，
	//详见图文分析数据接口中的msgid字段的介绍。
	private int msg_data_id;
	
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public int getMsg_data_id() {
		return msg_data_id;
	}
	public void setMsg_data_id(int msg_data_id) {
		this.msg_data_id = msg_data_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
