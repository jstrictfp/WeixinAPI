package cn.jstrictfp.weixin.entity.message.customservice;

import java.util.List;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 客服列表
 * @author Administrator
 *
 */
public class KFListResult extends Result{

	private List<KF> kf_list;

	public List<KF> getKf_list() {
		return kf_list;
	}

	public void setKf_list(List<KF> kf_list) {
		this.kf_list = kf_list;
	}
	
	public static class KF{
		
		private String kf_account;//完整客服账号，格式为：账号前缀@公众号微信号
		private String kf_nick;//客服昵称
		private String kf_id;//客服工号
		private String kf_headimgurl;//头像链接
		
		public String getKf_account() {
			return kf_account;
		}
		public void setKf_account(String kf_account) {
			this.kf_account = kf_account;
		}
		public String getKf_nick() {
			return kf_nick;
		}
		public void setKf_nick(String kf_nick) {
			this.kf_nick = kf_nick;
		}
		public String getKf_id() {
			return kf_id;
		}
		public void setKf_id(String kf_id) {
			this.kf_id = kf_id;
		}
		public String getKf_headimgurl() {
			return kf_headimgurl;
		}
		public void setKf_headimgurl(String kf_headimgurl) {
			this.kf_headimgurl = kf_headimgurl;
		}
	}

	@Override
	public String toString() {
		return "KFList [kf_list=" + kf_list + "]";
	}
	
	
	
}
