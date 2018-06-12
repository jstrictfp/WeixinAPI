package cn.jstrictfp.weixin.entity.comment;

/**
 * 评论操作
 * @author Administrator
 *
 */
public class MarkeLect extends OpenComment{

	//用户评论id
	private long user_comment_id;
	//回复内容(用于回复评论)
	private String content;

	public long getUser_comment_id() {
		return user_comment_id;
	}

	public void setUser_comment_id(long user_comment_id) {
		this.user_comment_id = user_comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
