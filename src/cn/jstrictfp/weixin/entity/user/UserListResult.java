package cn.jstrictfp.weixin.entity.user;

import java.util.Arrays;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 公众号关注者列表
 * 
 * @author Administrator
 *
 */
public class UserListResult extends Result{

	//公众号关注人数
	private Integer total;
	//获取的OpenId个数
	private Integer count;
	//拉取最后一个用户的OpenId
	private String next_openid;
	//OpenId列表
    private Data data;
	
	public UserListResult() {
		super();
	}
	
	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "WeiUserList [total=" + total + ", count=" + count
				+ ", next_openid=" + next_openid + ", data=" + data + "]";
	}
	
    public static class Data{
    	
    	private String[] openid;

    	public Data(){
    		super();
    	}
    	
		public String[] getOpenid() {
			return openid;
		}

		public void setOpenid(String[] openid) {
			this.openid = openid;
		}

		@Override
		public String toString() {
			return "OpenIds [openid=" + Arrays.toString(openid) + "]";
		}
		
    }
	
}
