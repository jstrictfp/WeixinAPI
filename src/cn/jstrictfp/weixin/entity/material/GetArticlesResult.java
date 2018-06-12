package cn.jstrictfp.weixin.entity.material;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取永久图文素材列表
 * @author Administrator
 *
 */
public class GetArticlesResult extends Result{

	//该类型的素材的总数
	private int total_count;
	//本次调用获取的素材的数量
	private int item_count;
	//获取的素材
	private List<Item> item;
	
	public static class Item{
		
		private String media_id;
		//图文列表
		private GetArticleResult content;
		//这篇图文消息素材的最后更新时间
		private String update_time;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		public GetArticleResult getContent() {
			return content;
		}
		public void setContent(GetArticleResult content) {
			this.content = content;
		}
		public String getUpdate_time() {
			return update_time;
		}
		public void setUpdate_time(String update_time) {
			this.update_time = update_time;
		}
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
}
