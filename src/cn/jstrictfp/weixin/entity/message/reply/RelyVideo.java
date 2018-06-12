package cn.jstrictfp.weixin.entity.message.reply;

/**
 * 回复视频消息
 * @author Administrator
 *
 */
public class RelyVideo extends Rely{
	
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String mediaId;
	//视频消息的标题
	private String title;
	//视频消息的描述
	private String description;
	
	public RelyVideo(String toUserName, String fromUserName, String msgType,
			String mediaId, String title, String description) {
		super(toUserName, fromUserName, "video");
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}
	
	@Override
	public String subXML() {
		StringBuilder str=new StringBuilder();
		str.append("<Video>");
		str.append("<MediaId><![CDATA["+mediaId+"]]></MediaId>");
		str.append("<Title><![CDATA["+title+"]]></Title>");
		str.append("<Description><![CDATA["+description+"]]></Description>");
		str.append("</Video>");
		return str.toString();
	}
	
}
