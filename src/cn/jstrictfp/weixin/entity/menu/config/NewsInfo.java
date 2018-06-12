package cn.jstrictfp.weixin.entity.menu.config;

import java.util.List;

/**
 * 自定义菜单配置中的图文消息列表
 * @author Administrator
 *
 */
public class NewsInfo {

	private List<News> list;

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

}
