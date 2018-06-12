package cn.jstrictfp.weixin.entity.media;

/**
 * 图文消息素材
 * 
 * 如果需要在群发图文中插入小程序，则在调用上传图文消息素材接口时，需在content字段中添加小程序跳转链接，有以下三种样式的可供选择。
 * 1.小程序卡片跳转小程序，代码示例：
 *  <mp-miniprogram data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index/index" data-miniprogram-title="小程序示例" data-progarm-imageurl="http://mmbizqbic.cn/demo.jpg"></mp-miniprogram>
 * 2.文字跳转小程序，代码示例：
 *  <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href="">点击文字跳转小程序</a></p>
 * 3.图片跳转小程序，代码示例：
 *  <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href=""><img data-src="http://mmbiz.qpic.cn/mmbiz_jpg/demo/0?wx_fmt=jpg"></a></p>
 *  参数说明
	参数	是否必须	说明
	data-miniprogram-appid	是	小程序的AppID
	data-miniprogram-path	是	小程序要打开的路径
	data-miniprogram-title	是	小程序卡片的标题，不超过35个字
	data-miniprogram-imageurl	是	小程序卡片的封面图链接，图片必须为1080*864像素
 * @author Administrator
 *
 */
public class Article {

	//图文消息的标题
    private String title;
	//图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
	private String thumb_media_id;
	//图文消息的作者
	private String author;
	//在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
	//(非必填)
	private String content_source_url;
	//图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
	private String content;
	//图文消息的描述，如本字段为空，则默认抓取正文前64个字
	private String digest;
	//是否显示封面，1为显示，0为不显示
	private int show_cover_pic;
	//是否打开评论，0不打开，1打开(可选)
	private int need_open_comment;
	//是否粉丝才可评论，0所有人可评论，1粉丝才可评论(可选)
	private int only_fans_can_comment;
	
	public Article(String thumb_media_id, String author, String title,
			String content_source_url, String content, String digest,
			int show_cover_pic) {
		super();
		this.thumb_media_id = thumb_media_id;
		this.author = author;
		this.title = title;
		this.content_source_url = content_source_url;
		this.content = content;
		this.digest = digest;
		this.show_cover_pic = show_cover_pic;
	}
	
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public int getShow_cover_pic() {
		return show_cover_pic;
	}
	public void setShow_cover_pic(int show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	public int getNeed_open_comment() {
		return need_open_comment;
	}

	public void setNeed_open_comment(int need_open_comment) {
		this.need_open_comment = need_open_comment;
	}

	public int getOnly_fans_can_comment() {
		return only_fans_can_comment;
	}

	public void setOnly_fans_can_comment(int only_fans_can_comment) {
		this.only_fans_can_comment = only_fans_can_comment;
	}
	
	
}
