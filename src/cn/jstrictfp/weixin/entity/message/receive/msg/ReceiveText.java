package cn.jstrictfp.weixin.entity.message.receive.msg;

/**
 * 接收文本消息
 * @author Administrator
 *
 */
public class ReceiveText extends Receive{
	
	//文本消息内容
	private String Content;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
