package cn.jstrictfp.weixin.entity.menu.add;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 查询菜单返回结果
 * @author Administrator
 *
 */
public class MenuResult extends Result{

	//默认菜单
	private MenuButtons menu;
    //个性化菜单列表
	private List<MenuButtons> conditionalmenu;

	public MenuButtons getMenu() {
		return menu;
	}

	public void setMenu(MenuButtons menu) {
		this.menu = menu;
	}

	public List<MenuButtons> getConditionalmenu() {
		return conditionalmenu;
	}

	public void setConditionalmenu(List<MenuButtons> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}

}
