package cn.jstrictfp.weixin.entity.comment;

/**
 * 开启评论
 * @author Administrator
 *
 */
public class OpenComment {

	//群发返回的msg_data_id
	private long msg_data_id;
	//多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
	private int index;
	
	public long getMsg_data_id() {
		return msg_data_id;
	}
	public void setMsg_data_id(long msg_data_id) {
		this.msg_data_id = msg_data_id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
