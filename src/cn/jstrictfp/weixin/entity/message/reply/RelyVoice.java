package cn.jstrictfp.weixin.entity.message.reply;

/**
 * 回复语音消息
 * @author Administrator
 *
 */
public class RelyVoice extends Rely{
	
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String mediaId;

	public RelyVoice(String toUserName, String fromUserName, String msgType,
			String mediaId) {
		super(toUserName, fromUserName, "voice");
		this.mediaId = mediaId;
	}

	@Override
	public String subXML() {
		StringBuilder str=new StringBuilder();
		str.append("<Voice>");
		str.append("<MediaId><![CDATA["+mediaId+"]]></MediaId>");
		str.append("</Voice>");
		return str.toString();
	}
	
}
