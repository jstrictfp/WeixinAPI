package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本消息预览
 * 
 * @author Administrator
 *
 */
public class TextPreview extends Preview{
	
	private Map<String,String> text;
	
	public TextPreview(String content){
		super();
		super.setMsgtype("text");
		this.text=new HashMap<String,String>();
		this.text.put("content",content);
	}

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}
	
}
