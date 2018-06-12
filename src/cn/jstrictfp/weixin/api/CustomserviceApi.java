package cn.jstrictfp.weixin.api;

import java.io.File;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.media.UploadMediaResult;
import cn.jstrictfp.weixin.entity.message.customservice.KFAccount;
import cn.jstrictfp.weixin.entity.message.customservice.KFListResult;
import cn.jstrictfp.weixin.entity.message.customservice.Message;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 公众号客服api
 * 
 * 当用户和公众号产生特定动作的交互时（具体动作列表请见下方说明），微信将会把消息数据推送给开发者，开发者可以在一段时间内（目前修改为48小时）调用客服接口，
 * 通过POST一个JSON数据包来发送消息给普通用户。此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
 * @author Administrator
 *
 */
public class CustomserviceApi extends Api {

	private static Logger logger = LoggerFactory.getLogger(CustomserviceApi.class);
	
	//添加客服账号
	private static final String ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	//修改客服账号
	private static final String UPDATE = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	//删除客服账号
	private static final String DEL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	//设置客服帐号的头像
	private static final String UPLOAD_HEADIMG = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	//获取所有客服账号
	private static final String GET_KF_LIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	//客服接口-发消息
	private static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	//客服输入状态
	private static final String TYPING = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=ACCESS_TOKEN";
	
	/**
	 * 客服发送消息 
	 * @param accessToken 接口凭据
	 * @param message 消息实体
	 * @return true|false
	 */
	public static Result send(String accessToken, Message message) {
		String reqUrl = SEND.replace(token(), accessToken);
		String json = JSONObject.fromObject(message).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("客服消息发送成功");
			return result;
		}
	    logger.error("客服消息发送失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 设置客服输入状态
	 * @param accessToken 接口调用凭据
	 * @param touser 用户openid
	 * @param command "Typing"：对用户下发“正在输入"状态   
	 *                "CancelTyping"：取消对用户的”正在输入"状态
	 * @return true|false
	 */
	public static Result typing(String accessToken, String touser, String command) {
		String reqUrl = TYPING.replace(token(), accessToken);
		String json = "{\"touser\":\"" + touser + "\", \"command\":\"" + command + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("客服输入状态下发成功");
			return result;
		}
		logger.error("图文消息素材上传失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取客服列表
	 * @param accessToken
	 * @return KFList
	 */
	public static KFListResult getKFList(String accessToken) {
		String reqUrl = GET_KF_LIST.replace(token(), accessToken);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), null);
		KFListResult kfList = (KFListResult) JSONObject.toBean(jsonObject, KFListResult.class);
		if(kfList.isSuccess()){
			logger.info("客服列表获取成功");
			return kfList;
		}
		logger.error("图文消息素材上传失败, errcode{}, errmsg{}", kfList.getErrcode(), kfList.getErrcode());
		return null;
	}
	
	/**
	 * 上传客服头像
	 * @param accessToken access_token
	 * @param kfAccount 完整客服账号
	 * @param filePath 头像
	 * @return BaseResult
	 */
	public static Result uploadHeadimg(String accessToken, String kfAccount, String filePath) {
		String reqUrl = UPLOAD_HEADIMG.replace(token(), accessToken).replace(kfAccount(), kfAccount);
		File file = new File(filePath);
		JSONObject jsonObject = HttpUtil.httpRequest(reqUrl, get(), file);
		UploadMediaResult result = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(result.isSuccess()){
			logger.info("客服" + kfAccount + "头像设置成功");
			return result;
		}
		logger.error("客服" + kfAccount + "头像设置失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 删除客服账号
	 * @param accessToken
	 * @param account
	 */
	private static Result delKFAccount(String accessToken, KFAccount account) {
		String reqUrl = DEL.replace(token(), accessToken);
    	String json = JSONObject.fromObject(account).toString();
    	JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), json);
    	Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("删除客服账号成功");
    		return result;
    	}
    	logger.error("删除客服账号失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
    }
	
	/**
	 * 修改客服账号
	 * @param accessToken
	 * @param account
	 */
	private static Result updateKFAccount(String accessToken, KFAccount account) {
		String reqUrl = UPDATE.replace(token(), accessToken);
    	String jsonKF = JSONObject.fromObject(account).toString();
    	JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), jsonKF);
    	Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("修改客服账号成功");
    		return result;
    	}
    	logger.error("修改客服账号失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
    }
	
	/**
	 * 添加客服账号
	 */
    public static Result addKFAccount(String accessToken, KFAccount account) {
    	String reqUrl = ADD.replace(token(), accessToken);
    	String jsonKF = JSONObject.fromObject(account).toString();
    	JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), jsonKF);
    	Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("添加客服账号成功");
    		return result;
    	}
    	logger.error("添加客服账号失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
    }
    
    public static void main(String[] args) {
    	KFAccount a=new KFAccount();
    	a.setKf_account("skdf");
    	a.setNickname("sdkf");
    	a.setPassword("skl");
		System.out.println(JSONObject.fromObject(a).toString());
	}
	
}
