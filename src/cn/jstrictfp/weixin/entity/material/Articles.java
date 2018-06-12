package cn.jstrictfp.weixin.entity.material;

import java.util.List;

import cn.jstrictfp.weixin.entity.media.Article;

/**
 * 永久图文素材
 * @author Administrator
 *
 */
public class Articles {

	//若新增的是多图文素材，则此处应有几段articles结构，最多8段
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
