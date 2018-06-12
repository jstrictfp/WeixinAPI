package cn.jstrictfp.weixin.entity.message.template;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 设置所属行业返回信息
 * @author Administrator
 *
 */
public class SetTempResult extends Result {
	
	//帐号设置的主营行业
	private String primary_industry;
	//帐号设置的副营行业
	private String secondary_industry;
	
	public String getPrimary_industry() {
		return primary_industry;
	}
	public void setPrimary_industry(String primary_industry) {
		this.primary_industry = primary_industry;
	}
	public String getSecondary_industry() {
		return secondary_industry;
	}
	public void setSecondary_industry(String secondary_industry) {
		this.secondary_industry = secondary_industry;
	}

}
