package cn.jstrictfp.weixin.entity.tag;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 用户的标签列表(返回信息)
 * @author Administrator
 *
 */
public class UserTagsResult extends Result {

	private int[] tagid_list;

	public int[] getTagid_list() {
		return tagid_list;
	}

	public void setTagid_list(int[] tagid_list) {
		this.tagid_list = tagid_list;
	}
	
}
