package cn.jstrictfp.weixin.entity.comment;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 指定文章的评论数据
 * 
 * @author Administrator
 *
 */
public class CommentListResult extends Result{

	//总数，非comment的size
	private int total;
	
	private Comment comment;
	
	public static class Comment{
		//用户评论id
		private int user_comment_id;
		//openid
		private String openid;  
		//评论时间
		private String create_time;  
        ////评论内容                  
		private String content;  
		//是否精选评论，0为即非精选，1为true，即精选
		private int comment_type;     
		
		private Reply reply;
		
		public int getUser_comment_id() {
			return user_comment_id;
		}

		public void setUser_comment_id(int user_comment_id) {
			this.user_comment_id = user_comment_id;
		}

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getCreate_time() {
			return create_time;
		}

		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getComment_type() {
			return comment_type;
		}

		public void setComment_type(int comment_type) {
			this.comment_type = comment_type;
		}

		public Reply getReply() {
			return reply;
		}

		public void setReply(Reply reply) {
			this.reply = reply;
		}

		public static class Reply{
			//作者回复内容
			private String content;
			//作者回复时间
			private String create_time;
			
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public String getCreate_time() {
				return create_time;
			}
			public void setCreate_time(String create_time) {
				this.create_time = create_time;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
