package cn.jstrictfp.weixin.entity.tag;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 微信公众号标签返回信息
 * @author Administrator
 *
 */
public class TagListResult extends Result {

	//标签列表
	private List<Tag> tags;
	
	public static class Tag{
		//标签id，由微信分配
		private int id;
		//标签名，UTF8编码
	    private String name;
	    //此标签下粉丝数
	    private int count;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		} 
	    
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
}
