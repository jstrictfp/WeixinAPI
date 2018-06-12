package cn.jstrictfp.weixin.entity.menu.conditional;

import cn.jstrictfp.weixin.entity.menu.add.Button;
import cn.jstrictfp.weixin.entity.menu.add.MatchRule;

/**
 * 个性化菜单
 * @author Administrator
 *
 */
public class ConditionalMenu {

	private Button[] button;
	
	private MatchRule matchrule;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public MatchRule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(MatchRule matchrule) {
		this.matchrule = matchrule;
	}
	
	
}
