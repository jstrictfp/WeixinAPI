package cn.jstrictfp.weixin.entity.material;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取永久视频素材素材返回结果
 * @author Administrator
 *
 */
public class GetVideoResult extends Result{

	//视频标题
	private String title;
	//视频介绍
	private String description;
	//视频下载url
	private String down_url;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDown_url() {
		return down_url;
	}
	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}
	
	@Override
	public String toString() {
		return "GetVideoResult [title=" + title + ", description="
				+ description + ", down_url=" + down_url + "]";
	}
	
}
