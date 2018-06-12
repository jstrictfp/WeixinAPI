package cn.jstrictfp.weixin.entity.material;

import java.util.List;

import cn.jstrictfp.weixin.entity.media.Article;

/**
 * 修改永久图文素材信息
 * @author Administrator
 *
 */
public class UpdateArticle {

	//要修改的图文消息的id
	private String media_id;
	//要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	private int index;
	//要更新的文章内容
	private List<Article> articles;
	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
