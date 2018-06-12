package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本消息
 * 
 * @author Administrator
 *
 */
public class TextMassMessage extends MassMessage{
	
	private Map<String,String> text;

	public TextMassMessage(String content) {
		super("text");
		this.text=new HashMap<String,String>();
		this.text.put("content", content);
	}

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}
	
}
