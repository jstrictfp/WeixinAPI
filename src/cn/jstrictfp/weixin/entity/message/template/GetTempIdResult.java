package cn.jstrictfp.weixin.entity.message.template;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取模板id返回值
 * @author Administrator
 *
 */
public class GetTempIdResult extends Result {
	
	private String template_id;

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
}
