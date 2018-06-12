package cn.jstrictfp.weixin.entity.core;

/**
 * 微信公众号配置信息
 * 
 * @author Wjh 
 * @author 1808429204@qq.com
 *
 */
public class Weixin{
	
	//微信公众号appid（唯一的）
	private String appId;
	//公众号秘钥
	private String appSecret;
	//开发者凭据（自定义的，与公众开发者配置保持一致）
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
}
