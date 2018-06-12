package cn.jstrictfp.weixin.entity.message.reply;

import java.util.ArrayList;
import java.util.List;

/**
 * 回复图文消息
 * @author Administrator
 *
 */
public class RelyArticle extends Rely{
	
	//图文消息个数，限制为8条以内
	private int articleCount;
	//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	private List<Article> articles;
	
	public RelyArticle(String toUserName,String fromUserName,List<Article> articles) {
		super(toUserName, fromUserName, "news");
		this.articleCount = articles.size();
		this.articles = articles;
	}

	public static class Article {
		//图文消息标题
		private String title;
		//图文消息描述
		private String description;
		//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		private String picUrl;
		//点击图文消息跳转链接
		private String url;
		
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
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getPicUrl() {
			return picUrl;
		}
		public void setPicurl(String picUrl) {
			this.picUrl = picUrl;
		}
	}

	@Override
	public String subXML() {
		StringBuilder str=new StringBuilder();
		str.append("<ArticleCount>"+articleCount+"</ArticleCount>");
		str.append("<Articles>");
		for(Article a:articles){
			str.append("<item>");
			str.append("<Title><![CDATA["+a.title+"]]></Title>");
			str.append("<Description><![CDATA["+a.description+"]]></Description>");
			str.append("<PicUrl><![CDATA["+a.picUrl+"]]></PicUrl>");
			str.append("<Url><![CDATA["+a.url+"]]></Url>");
			str.append("</item>");
		}
		str.append("</Articles>");
		return str.toString();
	}
	
	public static void main(String[] args) {
		List<Article> list=new ArrayList<Article>();
		Article a=new RelyArticle.Article();
		a.setDescription("skdfl");
		a.setPicurl("asfkl");
		a.setTitle("skjdfo");
		a.setUrl("shf");
		list.add(a);
		Article a1=new RelyArticle.Article();
		a1.setDescription("skdfl");
		a1.setPicurl("asfkl");
		a1.setTitle("skjdfo");
		a1.setUrl("shf");
		list.add(a1);
		RelyArticle r=new RelyArticle("hsdfkjh","shdfk",list);
		System.out.println(r.subXML());
	}
}
