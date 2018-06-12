package cn.jstrictfp.weixin.entity.message.reply;

/**
 * 回复音乐消息
 * @author Administrator
 *
 */
public class RelyMusic extends Rely{
	
	//音乐标题
	private String title;
	//音乐描述
	private String description;
	//音乐链接
	private String musicURL;
	//高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String hQMusicUrl;
	//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	private String thumbMediaId;
	
	public RelyMusic(String toUserName, String fromUserName, String msgType,
			String title, String description, String musicURL,
			String hQMusicUrl, String thumbMediaId) {
		super(toUserName, fromUserName, "music");
		this.title = title;
		this.description = description;
		this.musicURL = musicURL;
		this.hQMusicUrl = hQMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public String subXML() {
		StringBuilder str=new StringBuilder();
		str.append("<Music>");
		str.append("<Title><![CDATA["+title==null?"":title+"]]></Title>");
		str.append("<Description><![CDATA["+description==null?"":description+"]]></Description>");
		str.append("<MusicUrl><![CDATA["+musicURL==null?"":musicURL+"]]></MusicUrl>");
		str.append("<HQMusicUrl><![CDATA["+hQMusicUrl==null?"":hQMusicUrl+"]]></HQMusicUrl>");
		str.append("<ThumbMediaId><![CDATA["+thumbMediaId==null?"":thumbMediaId+"]]></ThumbMediaId>");
		str.append("<Music>");
		return str.toString();
	}
	
}
