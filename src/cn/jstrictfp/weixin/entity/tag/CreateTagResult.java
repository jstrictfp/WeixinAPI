package cn.jstrictfp.weixin.entity.tag;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.tag.TagListResult.Tag;

/**
 * 创建标签返回信息
 * @author Administrator
 *
 */
public class CreateTagResult extends Result {

	private Tag tag;

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	
}
