package cn.jstrictfp.weixin.entity.menu.conditional;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 自定义个性菜单 返回结果
 * @author Administrator
 *
 */
public class ConditionalMenuResult extends Result{

	private String menuid;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
    	
}
