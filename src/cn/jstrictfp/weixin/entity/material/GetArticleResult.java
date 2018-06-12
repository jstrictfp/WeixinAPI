package cn.jstrictfp.weixin.entity.material;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.media.Article;

/**
 * 获取永久图文素材素材返回结果
 * @author Administrator
 *
 */
public class GetArticleResult extends Result{

	private List<Article> news_item;

	public List<Article> getNews_item() {
		return news_item;
	}

	public void setNews_item(List<Article> news_item) {
		this.news_item = news_item;
	}
	
}
