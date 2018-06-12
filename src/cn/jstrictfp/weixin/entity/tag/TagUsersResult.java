package cn.jstrictfp.weixin.entity.tag;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.user.UserListResult.Data;

/**
 * 获取标签下粉丝列表返回信息
 * @author Administrator
 *
 */
public class TagUsersResult extends Result {
	//这次获取的粉丝数量
	private int count;
	//粉丝列表
	private Data data;
	//拉取列表最后一个用户的openid
	private String next_openid;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

}
