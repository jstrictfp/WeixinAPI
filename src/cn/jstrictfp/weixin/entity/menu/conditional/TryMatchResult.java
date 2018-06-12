package cn.jstrictfp.weixin.entity.menu.conditional;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.menu.add.Button;

/**
 * 个性化菜单匹配结果
 * @author Administrator
 *
 */
public class TryMatchResult extends Result{

	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}
	
}
