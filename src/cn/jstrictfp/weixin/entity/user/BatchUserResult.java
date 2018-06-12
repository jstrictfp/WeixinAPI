package cn.jstrictfp.weixin.entity.user;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 批量用户信息
 * @author Administrator
 *
 */
public class BatchUserResult extends Result{

	//关注者列表
	private List<UserResult> user_info_list;

	public List<UserResult> getUser_info_list() {
		return user_info_list;
	}

	public void setUser_info_list(List<UserResult> user_info_list) {
		this.user_info_list = user_info_list;
	}
	
}
