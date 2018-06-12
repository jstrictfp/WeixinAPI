package cn.jstrictfp.weixin.entity.user;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 网页授权获取的用户信息
 * 
 * @author Administrator
 *
 */
public class UserResult extends Result{
	
	//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private int subscribe;		
	//用户的标识，对当前公众号唯一
	private String openid;			
    //用户昵称
	private String nickname;
	//昵称 表情转义
	private String nickname_emoji;	
    //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private int sex;			
    
	private String language;
	//普通用户个人资料填写的城市
	private String city;
    //用户个人资料填写的省份
	private String province;
    //国家，如中国为CN
	private String country;
    //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	private String headimgurl;
    
	private int subscribe_time;
	//sns 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	private String[] privilege;		
	//多个公众号之间用户帐号互通UnionID机制 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private String unionid;			

	private int groupid;
	//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String remark;			
	//用户被打上的标签ID列表
	private int[] tagid_list;
	
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname_emoji() {
		return nickname_emoji;
	}
	public void setNickname_emoji(String nickname_emoji) {
		this.nickname_emoji = nickname_emoji;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public int getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(int subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int[] getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(int[] tagid_list) {
		this.tagid_list = tagid_list;
	}
	
}
