package cn.jstrictfp.weixin.entity.message.template;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取行业信息返回值
 * 
 * @author Administrator
 *
 */
public class GetTempResult extends Result {
	
	//帐号设置的主营行业
	private Industry primary_industry;
	//帐号设置的副营行业
	private Industry secondary_industry;
	
	public static class Industry{
		
		private String first_class;
		
		private String second_class;

		public String getFirst_class() {
			return first_class;
		}

		public void setFirst_class(String first_class) {
			this.first_class = first_class;
		}

		public String getSecond_class() {
			return second_class;
		}

		public void setSecond_class(String second_class) {
			this.second_class = second_class;
		}
		
	}

	public Industry getPrimary_industry() {
		return primary_industry;
	}

	public void setPrimary_industry(Industry primary_industry) {
		this.primary_industry = primary_industry;
	}

	public Industry getSecondary_industry() {
		return secondary_industry;
	}

	public void setSecondary_industry(Industry secondary_industry) {
		this.secondary_industry = secondary_industry;
	}
	
}
