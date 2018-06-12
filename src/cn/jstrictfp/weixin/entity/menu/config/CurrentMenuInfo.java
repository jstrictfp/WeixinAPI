package cn.jstrictfp.weixin.entity.menu.config;

import cn.jstrictfp.weixin.entity.core.Result;

public class CurrentMenuInfo extends Result{

	//菜单是否开启，0代表未开启，1代表开启
	private Integer is_menu_open;
	//菜单信息
	private MenuInfo selfmenu_info;

	public Integer getIs_menu_open() {
		return is_menu_open;
	}

	public void setIs_menu_open(Integer is_menu_open) {
		this.is_menu_open = is_menu_open;
	}

	public MenuInfo getSelfmenu_info() {
		return selfmenu_info;
	}

	public void setSelfmenu_info(MenuInfo selfmenu_info) {
		this.selfmenu_info = selfmenu_info;
	}

}
