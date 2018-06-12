package cn.jstrictfp.weixin.api;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.user.BatchUserResult;
import cn.jstrictfp.weixin.entity.user.UserResult;
import cn.jstrictfp.weixin.entity.user.UserListResult;
import cn.jstrictfp.weixin.util.EmojiUtil;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 用户管理Api
 * @author Administrator
 *
 */
public class UserApi extends Api{

	private static Logger log = LoggerFactory.getLogger(UserApi.class);  
	
	//获取单个用户信息
	private static final String USER_INFO="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//获取关注者列表
	private static final String OPENID_LIST="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	//批量获取用户信息
	private static final String USER_LIST="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	//设置用户的备注名
	private static final String SET_REMARK="https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	//获取公众号的黑名单列表
	private static final String GET_BLACK_LIST="https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";
	//拉黑用户
	private static final String BATCH_ADD_BLACK_LIST="https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
	//取消拉黑用户
	private static final String BATCH_CANCEL_BLACK_LIST="https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";
	
	/**
	 * 批量取消拉黑
	 * @param accessToken 接口调用凭据
	 * @param openIds 要拉黑的用户openid列表，一次拉黑最多允许20个
	 * @return
	 */
	public static Result cancelBlackList(String accessToken,List<String> openIds){
		String reqUrl=BATCH_CANCEL_BLACK_LIST.replace(token(), accessToken);
		StringBuffer str=new StringBuffer();
		str.append("{\"openid_list\":[");
		for(int i=0;i<openIds.size();i++){
			str.append("\"").append(openIds.get(i)).append("\"").append(i==openIds.size()-1?"":",");
		}
		str.append("]}");
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",str.toString());
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("用户批量取黑成功");
			return result;
		}
		log.error("用户批量取黑失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 批量拉黑用户
	 * @param accessToken 接口调用凭据
	 * @param openIds 要拉黑的用户openid列表，一次拉黑最多允许20个
	 * @return
	 */
	public static Result addBlackList(String accessToken,List<String> openIds){
		String reqUrl=BATCH_ADD_BLACK_LIST.replace(token(), accessToken);
		StringBuffer str=new StringBuffer();
		str.append("{\"openid_list\":[");
		for(int i=0;i<openIds.size();i++){
			str.append("\"").append(openIds.get(i)).append("\"").append(i==openIds.size()-1?"":",");
		}
		str.append("]}");
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",str.toString());
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("用户批量拉黑成功");
			return result;
		}
		log.error("用户批量拉黑失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取公众号的黑名单列表
	 * @param accessToken 接口调用凭据
	 * @param beginOpenId 当 begin_openid 为空时，默认从开头拉取。
	 * @return
	 */
	public static UserListResult getBlackList(String accessToken,String beginOpenId){
		// 拼接请求地址
	    String requestUrl = GET_BLACK_LIST.replace(token(), accessToken);
	    // 拼接json数据
	    String json="{\"begin_openid\":\""+beginOpenId+"\"}";
	    // 获取关注者列表
	    JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "POST", json);
	    UserListResult result =(UserListResult) JSONObject.toBean(jsonObject,UserListResult.class);
        if(result.isSuccess()){
			log.info("黑名单列表获取成功");
			return result;
		}
		log.error("黑名单列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 为用户设置备注名
	 * @param accessToken 接口调用凭据
	 * @param openId 用户id
	 * @param remark 新的备注名，长度必须小于30字符 
	 * @return
	 */
	public static Result setRemark(String accessToken,String openId,String remark){
		// 拼接请求地址
	    String requestUrl = SET_REMARK.replace(token(), accessToken);
	    // 拼接json数据
	    String json="{\"openid\":\""+openId+"\",\"remark\":\""+remark+"\"}";
	    // 获取关注者列表
	    JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", json);
	    System.out.println("jsonObject:"+jsonObject);
	    Result result =(Result) JSONObject.toBean(jsonObject,Result.class);
        if(result.isSuccess()){
			log.info("用户备注名设置成功");
			return result;
		}
		log.error("用户备注名设置失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取关注者信息  
	 * @param accessToken
	 * @param openId
	 * @param emoji 转换的模式  0  不设置 <br>
						  1 HtmlHex 格式<br>
						  2 HtmlTag 格式<br>
						  3 Alias  格式<br>
						  4 HtmlDec 格式<br>
						  5 PureText 纯文本<br>
	 * @return
	 */
    public static UserResult getUserInfo(String accessToken, String openId,int emoji) {
        // 拼接请求地址
        String requestUrl = USER_INFO.replace(token(), accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);
        UserResult user = (UserResult) JSONObject.toBean(jsonObject, UserResult.class);
        if(user.isSuccess()){
			log.info("用户信息获取成功");
			if(emoji != 0 && user != null && user.getNickname() != null){
				user.setNickname(EmojiUtil.parse(user.getNickname(), emoji));
			}
			return user;
		}
		log.error("用户信息获取失败，errcode{},errmsg{}",user.getErrcode(),user.getErrcode());
		return null;
    } 
    
   /**
    * 获取关注者列表  
    */
	public static UserListResult getUserInfoList(String accessToken,String nextOpenId){
	    // 拼接请求地址
	    String requestUrl = OPENID_LIST.replace(token(), accessToken).replace("NEXT_OPENID", nextOpenId);
	    // 获取关注者列表
	    JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);
	    System.out.println("jsonObject:"+jsonObject);
	    UserListResult result =(UserListResult) JSONObject.toBean(jsonObject,UserListResult.class);
        if(result.isSuccess()){
			log.info("用户列表获取成功");
			return result;
		}
		log.error("用户列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	} 
	
	/**
	 * 批量获取用户信息
	 * @param accessToken 
	 * @param openIds openid列表
	 * @param lang 语言
	 * @param emoji 转换的模式  0  不设置 <br>
						  1 HtmlHex 格式<br>
						  2 HtmlTag 格式<br>
						  3 Alias  格式<br>
						  4 HtmlDec 格式<br>
						  5 PureText 纯文本<br>
	 * @return
	 */
	public static BatchUserResult getBatchUser(String accessToken,List<String> openIds,int emoji){
		String requestUrl = USER_LIST.replace(token(), accessToken);
		String lang="zh_CN";
		StringBuilder sb = new StringBuilder();
		sb.append("{\"user_list\": [");
		for(int i = 0;i < openIds.size();i++){
			sb.append("{")
			  .append("\"openid\": \"").append(openIds.get(i)).append("\",")
			  .append("\"lang\": \"").append(lang).append("\"")
			  .append("}").append(i==openIds.size()-1?"":",");
		}
		sb.append("]}");
		String json = sb.toString();
		// 获取关注者列表
	    JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "POST", json);
	    BatchUserResult result = (BatchUserResult) JSONObject.toBean(jsonObject,BatchUserResult.class);
        if(result.isSuccess()){
			log.info("批量获取用户信息成功");
			if(emoji != 0 && result != null && result.getUser_info_list() != null){
				for(UserResult user : result.getUser_info_list()){
					if(user.getNickname() != null){
						user.setNickname(EmojiUtil.parse(user.getNickname(), emoji));
					}
				}
			}
			return result;
		}
		log.error("批量获取用户信息失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
}
