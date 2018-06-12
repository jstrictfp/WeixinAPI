package cn.jstrictfp.weixin.entity.message.subscribemsg;

import java.util.List;
import java.util.Map;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 公众号自动回复规则
 * 
 * @author Administrator
 * 
 */
public class AutomaticReplyRule extends Result {

	//关注后自动回复是否开启，0代表未开启，1代表开启
	private int is_add_friend_reply_open;
    //消息自动回复是否开启，0代表未开启，1代表开启
	private int is_autoreply_open;
	//关注后自动回复的信息
	private Map<String, String> add_friend_autoreply_info;
    //消息自动回复的信息
	private Map<String, String> message_default_autoreply_info;
    //关键词自动回复的信息
	private KeywordAutoreplyInfo keyword_autoreply_info;

	public class KeywordAutoreplyInfo {

		private List<KeywordReply> list;

		public class KeywordReply {
            //rule_name
			private String rule_name;
            //create_time
			private int create_time;
            //回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
			private String reply_mode;
            //匹配的关键词列表
			private List<KeywordListInfo> keyword_list_info;
            //
			private List<ReplyListInfo> reply_list_info;

			public class KeywordListInfo {
                //自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），
				//关键词自动回复则还多了图文消息（news）
				private String type;
                //匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
				private String match_mode;
                //对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
				private String content;

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getMatch_mode() {
					return match_mode;
				}

				public void setMatch_mode(String match_mode) {
					this.match_mode = match_mode;
				}

				public String getContent() {
					return content;
				}

				public void setContent(String content) {
					this.content = content;
				}

			}

			public class ReplyListInfo {
				
				private String type;

				private String content;
                //图文消息的信息
				private NewsInfoList news_info;

				public class NewsInfoList {

					private List<NewsInfo> list;

					public class NewsInfo {
                        //图文消息的标题
						private String title;
                        //作者
						private String author;
                        //摘要
						private String digest;
                        //是否显示封面，0为不显示，1为显示
						private int show_cover;
						//封面图片的URL
						private String cover_url;
                        //正文的URL
						private String content_url;
                        //原文的URL，若置空则无查看原文入口
						private String source_url;

						public String getTitle() {
							return title;
						}

						public void setTitle(String title) {
							this.title = title;
						}

						public String getAuthor() {
							return author;
						}

						public void setAuthor(String author) {
							this.author = author;
						}

						public String getDigest() {
							return digest;
						}

						public void setDigest(String digest) {
							this.digest = digest;
						}

						public int getShow_cover() {
							return show_cover;
						}

						public void setShow_cover(int show_cover) {
							this.show_cover = show_cover;
						}

						public String getCover_url() {
							return cover_url;
						}

						public void setCover_url(String cover_url) {
							this.cover_url = cover_url;
						}

						public String getContent_url() {
							return content_url;
						}

						public void setContent_url(String content_url) {
							this.content_url = content_url;
						}

						public String getSource_url() {
							return source_url;
						}

						public void setSource_url(String source_url) {
							this.source_url = source_url;
						}

					}

					public List<NewsInfo> getList() {
						return list;
					}

					public void setList(List<NewsInfo> list) {
						this.list = list;
					}

				}

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getContent() {
					return content;
				}

				public void setContent(String content) {
					this.content = content;
				}

				public NewsInfoList getNews_info() {
					return news_info;
				}

				public void setNews_info(NewsInfoList news_info) {
					this.news_info = news_info;
				}

			}

			public String getRule_name() {
				return rule_name;
			}

			public void setRule_name(String rule_name) {
				this.rule_name = rule_name;
			}

			public Integer getCreate_time() {
				return create_time;
			}

			public void setCreate_time(Integer create_time) {
				this.create_time = create_time;
			}

			public String getReply_mode() {
				return reply_mode;
			}

			public void setReply_mode(String reply_mode) {
				this.reply_mode = reply_mode;
			}

			public List<KeywordListInfo> getKeyword_list_info() {
				return keyword_list_info;
			}

			public void setKeyword_list_info(
					List<KeywordListInfo> keyword_list_info) {
				this.keyword_list_info = keyword_list_info;
			}

			public List<ReplyListInfo> getReply_list_info() {
				return reply_list_info;
			}

			public void setReply_list_info(List<ReplyListInfo> reply_list_info) {
				this.reply_list_info = reply_list_info;
			}

		}

		public List<KeywordReply> getList() {
			return list;
		}

		public void setList(List<KeywordReply> list) {
			this.list = list;
		}

	}

	public int getIs_add_friend_reply_open() {
		return is_add_friend_reply_open;
	}

	public void setIs_add_friend_reply_open(Integer is_add_friend_reply_open) {
		this.is_add_friend_reply_open = is_add_friend_reply_open;
	}

	public int getIs_autoreply_open() {
		return is_autoreply_open;
	}

	public void setIs_autoreply_open(Integer is_autoreply_open) {
		this.is_autoreply_open = is_autoreply_open;
	}

	public Map<String, String> getAdd_friend_autoreply_info() {
		return add_friend_autoreply_info;
	}

	public void setAdd_friend_autoreply_info(
			Map<String, String> add_friend_autoreply_info) {
		this.add_friend_autoreply_info = add_friend_autoreply_info;
	}

	public Map<String, String> getMessage_default_autoreply_info() {
		return message_default_autoreply_info;
	}

	public void setMessage_default_autoreply_info(
			Map<String, String> message_default_autoreply_info) {
		this.message_default_autoreply_info = message_default_autoreply_info;
	}

	public KeywordAutoreplyInfo getKeyword_autoreply_info() {
		return keyword_autoreply_info;
	}

	public void setKeyword_autoreply_info(
			KeywordAutoreplyInfo keyword_autoreply_info) {
		this.keyword_autoreply_info = keyword_autoreply_info;
	}

}
