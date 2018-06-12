package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.message.mass.MassMessage;
import cn.jstrictfp.weixin.entity.message.mass.MassSpeedResult;
import cn.jstrictfp.weixin.entity.message.mass.SendAllResult;
import cn.jstrictfp.weixin.entity.message.preview.Preview;
import cn.jstrictfp.weixin.entity.message.preview.PreviewResult;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 公众号群发接口
 * @author Administrator
 *
 */
public class MassApi extends Api {
	
	private static Logger logger = LoggerFactory.getLogger(MassApi.class);
	
	//根据用户分组群发
	private static final String SEND_ALL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	//根据openid列表发送
	private static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
	//删除群发
	private static final String DELETE = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
	//预览接口,开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版，次数限制为100此每天
	private static final String PREVIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	//查询群发消息发送状态
	private static final String GET_MASS = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
	//获取群发速度
	private static final String GET_SPEED = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/get?access_token=ACCESS_TOKEN";
	//设置群发速度
	private static final String SET_SPEED = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token=ACCESS_TOKEN";
	
	/**
	 * 设置群发速度
	 * @param accessToken 接口调用凭证
	 * @param speed 群发速度级别
	 * @return
	 */
	public static Result setSpeed(String accessToken, int speed) {
		String reqUrl = SET_SPEED.replace(token(), accessToken);
		String json = "{\"speed\":\"" + speed + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("群发速度设置成功");
			return result;
		}
		logger.error("群发速度设置失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取群发速度
	 * @param accessToken 接口调用凭证
	 * @return
	 */
	public static MassSpeedResult getSpeed(String accessToken) {
		String reqUrl = GET_SPEED.replace(token(), accessToken);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), null);
		MassSpeedResult result = (MassSpeedResult) JSONObject.toBean(jsonObject, JSONObject.class);
		if(result.isSuccess()){
			logger.info("群发速度获取成功");
			return result;
		}
		logger.error("群发速度获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 删除群发
	 * @param accessToken 接口调用凭证
	 * @param msgId 发送出去的消息ID
	 * @param articleIdx  要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
	 * @return
	 */
	public static Result delete(String accessToken, int msgId, int articleIdx) {
		String reqUrl = DELETE.replace(token(), accessToken);
		String json = "{\"msg_id\":\"" + msgId + "\", \"article_idx\":\"" + articleIdx + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("群发删除成功");
    		return result;
    	}
    	logger.error("群发删除失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
	}
	
	/**
	 * 查询群发消息发送状态
	 * @param accessToken 接口调用凭证
	 * @param msgId 群发id
	 * @return
	 */
	public static PreviewResult getStatus(String accessToken, String msgId) {
		String reqUrl = GET_MASS.replace(token(), accessToken);
		String json = "{\"msg_id\":\"" + msgId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		PreviewResult result = (PreviewResult) JSONObject.toBean(jsonObject, PreviewResult.class);
		if(result.isSuccess()){
			logger.info("群发发送状态获取成功");
			return result;
		}
		logger.error("群发发送状态获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrmsg());
		return null;
	}
	
	/**
	 * 发送预览消息
	 * @param accessToken 接口调用凭证
	 * @param preview 
	 * @return
	 */
	public static PreviewResult perview(String accessToken, Preview preview) {
		String reqUrl = PREVIEW.replace(token(), accessToken);
		String json = JSONObject.fromObject(preview).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		PreviewResult result = (PreviewResult) JSONObject.toBean(jsonObject, PreviewResult.class);
		if(result.isSuccess()){
			logger.info("预览消息发送成功");
			return result;
		}
		logger.error("预览消息发送失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrmsg());
		return null;
	}
	
	/**
	 * 根据openid列表群发
	 * @param accessToken 接口调用凭证
	 * @param mass
	 * @return
	 */
	public static SendAllResult sendAllOpenId(String accessToken, MassMessage mass) {
		String reqUrl = SEND.replace(token(), accessToken);
		String json = JSONObject.fromObject(mass).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		SendAllResult result = (SendAllResult) JSONObject.toBean(jsonObject, SendAllResult.class);
		if(result.isSuccess()){
			logger.info("根据openid列表群发成功");
			return result;
		}
		logger.error("根据openid列表群发失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrmsg());
		return null;
	}
	
	/**
	 * 根据标签群发
	 * @param accessToken  接口调用凭证
	 * @param mass
	 * @return
	 */
	public static SendAllResult sendAllTag(String accessToken, MassMessage mass) {
		String reqUrl = SEND_ALL.replace(token(), accessToken);
		String json = JSONObject.fromObject(mass).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(),json);
		SendAllResult result = (SendAllResult) JSONObject.toBean(jsonObject, SendAllResult.class);
		if(result.isSuccess()){
			logger.info("根据标签群发成功");
			return result;
		}
		logger.error("根据标签群发失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
}
