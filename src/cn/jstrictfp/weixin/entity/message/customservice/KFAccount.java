package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 公众号客服账号
 * @author Administrator
 *
 */
public class KFAccount {
	//客服账号 完整客服账号，格式为：账号前缀@公众号微信号，账号前缀最多10个字符，必须是英文或者数字字符。如果没有公众号微信号，请前往微信公众平台设置
	private String kf_account;
	//客服昵称，最长6个汉字或12个英文字符
	private String nickname;
	//客服账号登录密码，格式为密码明文的32位加密MD5值
	private String password;
	
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
