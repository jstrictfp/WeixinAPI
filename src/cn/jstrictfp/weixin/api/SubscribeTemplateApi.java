package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.message.subscribemsg.AutomaticReplyRule;
import cn.jstrictfp.weixin.entity.message.subscribemsg.Subscribe;
import cn.jstrictfp.weixin.entity.message.subscribemsg.SubscribeTemplate;
import cn.jstrictfp.weixin.util.CommonUtil;
import cn.jstrictfp.weixin.util.HttpUtil;
import cn.jstrictfp.weixin.util.JSONUtil;
import cn.jstrictfp.weixin.util.WeixinUtil;

/**
 * 一次性订阅模板消息
 * 
 * 开发者可以通过一次性订阅消息授权让微信用户授权第三方移动应用或公众号，获得发送一次订阅消息给到授权微信用户的机会。
 * 授权微信用户可以不需要关注公众号。微信用户每授权一次，开发者可获得一次下发消息的权限。
 * 对于已关注公众号的，消息将下发到公众号会话；未关注公众号的，将下发到服务通知。
 * @author Administrator
 *
 */
public class SubscribeTemplateApi extends Api {
	
	private static Logger logger=LoggerFactory.getLogger(SubscribeTemplateApi.class);
	//推送订阅模板消息给到授权微信用户
	private static final String SUBSCRIBE="https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=ACCESS_TOKEN";
	//获取公众号自动回复规则
    private static final String GET_CURRENT_AUTOREPLY_INFO="https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";
	//
    private static final String SUBSCRIBE_MSG="https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&appid=APPID&scene=SCENEN&template_id=TEMPLATE_ID&redirect_url=REDIRECT_URL&reserved=RESERVED#wechat_redirect";
    /**
     * 获取自动回复规则
     * @param accessToken
     * @return
     */
    public static AutomaticReplyRule getCurrentAutoreply(String accessToken){
    	String reqUrl=GET_CURRENT_AUTOREPLY_INFO.replace(token(), accessToken);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, get(), null);
		AutomaticReplyRule result=(AutomaticReplyRule) JSONObject.toBean(jsonObject,AutomaticReplyRule.class);
		if(result.isSuccess()){
			logger.info("自动回复规则获取成功");
			return result;
		}
		logger.error("自动回复规则获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
    }
    
    /**
	 * 发送一次性订阅模板消息
	 * @param accessToken 接口调用凭据
	 * @param message 订阅模板消息
	 * @return
	 */
	public static Result sendSubscribe(String accessToken,SubscribeTemplate message){
		String reqUrl=SUBSCRIBE.replace(token(), accessToken);
		String json = JSONUtil.toJSONString(message);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			logger.info("订阅模板消息成功");
			return result;
		}
		logger.error("订阅模板消息发送失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 生成一次性订阅授权链接
	 * @param sub 用户自定义链接内容
	 * @return
	 */
	public static String getSubscribeUrl(Subscribe sub){
		
		SUBSCRIBE_MSG.replace("APPID", WeixinUtil.instance().getAppid());
		SUBSCRIBE_MSG.replace("SCENEN", String.valueOf(sub.getScene()));
		SUBSCRIBE_MSG.replace("TEMPLATE_ID", sub.getTemplateId());
		SUBSCRIBE_MSG.replace("REDIRECT_URL", CommonUtil.urlEncodeUTF8(sub.getRedirectUrl()));
		SUBSCRIBE_MSG.replace("RESERVED", CommonUtil.urlEncodeUTF8(sub.getReserved()));
    	
        System.out.println("一次性订阅链接为:"+SUBSCRIBE_MSG);
        return SUBSCRIBE_MSG;
	}
	
}
