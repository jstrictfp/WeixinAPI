package cn.jstrictfp.weixin.entity.material;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取其他永久素材列表
 * @author Administrator
 *
 */
public class GetMaterialsResult extends Result{

	//该类型的素材的总数
	private int total_count;
	//本次调用获取的素材的数量
	private int item_count;
	//获取的素材
	private List<Item> item;
	
	public static class Item{
		
		private String media_id;
		//文件名称
		private String name;
		//这篇图文消息素材的最后更新时间
		private String update_time;
		//当获取的列表是图片素材列表时，该字段是图片的URL
		private String url;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUpdate_time() {
			return update_time;
		}
		public void setUpdate_time(String update_time) {
			this.update_time = update_time;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
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
