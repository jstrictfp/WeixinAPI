package cn.jstrictfp.weixin.entity.message.customservice;

import java.util.List;

import cn.jstrictfp.weixin.entity.message.reply.RelyArticle.Article;

/**
 * 图文消息（点击跳转到外链），条数限制在8条内
 * @author Administrator
 *
 */
public class NewsMessage extends Message {

	public NewsMessage(String touser) {
		super(touser, "news");
	}
	
	public NewsMessage(String touser,News news){
		this(touser);
		this.news=news;
	}
	
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public static class News{
		
		private List<Article> article;

		public List<Article> getArticle() {
			return article;
		}

		public void setArticle(List<Article> article) {
			this.article = article;
		}
		
	}
	
}
