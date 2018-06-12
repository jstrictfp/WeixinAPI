package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 文本消息
 * @author Administrator
 *
 */
public class TextMessage extends Message {
	
	private Text text;
	
	public TextMessage(String touser){
		super(touser,"text");
	}
	
	public TextMessage(String touser,String content) {
		this(touser);
		this.text = new Text();
		this.text.setContent(content);
	}

	public static class Text{
		//消息内容
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
	}

}
