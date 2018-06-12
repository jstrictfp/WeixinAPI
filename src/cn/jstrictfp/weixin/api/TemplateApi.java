package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.message.template.GetTempIdResult;
import cn.jstrictfp.weixin.entity.message.template.GetTempResult;
import cn.jstrictfp.weixin.entity.message.template.SendTempResult;
import cn.jstrictfp.weixin.entity.message.template.SetTempResult;
import cn.jstrictfp.weixin.entity.message.template.TempListResult;
import cn.jstrictfp.weixin.entity.message.template.TemplateMessage;
import cn.jstrictfp.weixin.util.HttpUtil;
import cn.jstrictfp.weixin.util.JSONUtil;

/**
 * 模板消息接口
 * @author Administrator
 *
 */
public class TemplateApi extends Api {

	private static Logger logger=LoggerFactory.getLogger(TemplateApi.class);
	//设置公众号所处行业 POST
	private static final String SET_INDUSTRY="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	//获取设置的行业信息 GET
	private static final String GET_INDUSTRY="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
	//获取模板id POST
	private static final String GET_TEMPLATE_ID="https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	//获取模板列表 GET
	private static final String GET_ALL_TEMPLATE="https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	//删除模板 POST
	private static final String DEL_TEMPLATE="https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
	//发送模板消息 POST
	private static final String SEND_TEMPLATE="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	
	/**
	 * 发送模板消息
	 * @param accessToken 接口调用凭据
	 * @param message 模板消息内容
	 * @return
	 */
	public static SendTempResult sendTemplate(String accessToken,TemplateMessage message){
		String reqUrl=SEND_TEMPLATE.replace(token(), accessToken);
		String json = JSONUtil.toJSONString(message);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, post(), json);
		SendTempResult result=(SendTempResult) JSONObject.toBean(jsonObject,SendTempResult.class);
		if(result.isSuccess()){
			logger.info("模板消息成功");
			return result;
		}
		logger.error("模板消息发送失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 删除模板消息
	 * @param accessToken 接口调用凭据
	 * @param template_id 模板id
	 * @return
	 */
	public static Result delTemplate(String accessToken,String template_id){
		String reqUrl=DEL_TEMPLATE.replace(token(), accessToken);
		String json="{\"template_id\":"+template_id+"}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			logger.info("模板列表删除成功");
			return result;
		}
		logger.error("模板列表删除失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取模板列表 
	 * @param accessToken 接口调用凭据
	 * @return
	 */
	public static TempListResult getAllTemplate(String accessToken){
		String reqUrl=GET_ALL_TEMPLATE.replace(token(), accessToken);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, get(), null);
		TempListResult result=(TempListResult) JSONObject.toBean(jsonObject,TempListResult.class);
		if(result.isSuccess()){
			logger.info("模板列表获取成功");
			return result;
		}
		logger.error("模板列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取模板Id
	 * @param accessToken 接口调用凭据
	 * @param template_id_short 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
	 * @return
	 */
	public static GetTempIdResult getTemplateId(String accessToken,String template_id_short){
		String reqUrl=GET_TEMPLATE_ID.replace(token(),accessToken);
		String json="{\"template_id_short\":"+template_id_short+"}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, post(),json);
		GetTempIdResult result=(GetTempIdResult) JSONObject.toBean(jsonObject,GetTempIdResult.class);
		if(result.isSuccess()){
			logger.info("模板Id获取成功");
			return result;
		}
		logger.error("模板Id获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取设置的行业信息
	 * @param accessToken 接口调用凭证
	 * @return
	 */
	private static GetTempResult getIndustry(String accessToken){
		String reqUrl=GET_INDUSTRY.replace(token(), accessToken);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, get(),null);
		GetTempResult result=(GetTempResult) JSONObject.toBean(jsonObject,GetTempResult.class);
		if(result.isSuccess()){
			logger.info("所属行业获取成功");
			return result;
		}
		logger.error("所属行业获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 设置公众号所属行业
	 * @param accessToken 接口调用凭证
	 * @param industry_id1 公众号模板消息所属行业编号
	 * @param industry_id2 公众号模板消息所属行业编号
	 * 主行业	                       副行业	                    代码
		IT科技	互联网/电子商务			1
		IT科技	IT软件与服务			2
		IT科技	IT硬件与设备			3
		IT科技	电子技术				4
		IT科技	通信与运营商			5
		IT科技	网络游戏				6
		金融业	银行					7
		金融业	基金|理财|信托	        8
		金融业	保险                                           9
		餐饮	          餐饮	                10
		酒店旅游	酒店	                11
		酒店旅游	旅游	                12
		运输与仓储	快递	                13
		运输与仓储	物流	                14
		运输与仓储	仓储	                15
		教育	          培训	                16
		教育	          院校	                17
		政府与公共事业	学术科研	        18
		政府与公共事业	交警	            19
		政府与公共事业	博物馆	        20
		政府与公共事业	公共事业|非盈利机构	21
		医药护理	医药医疗				22
		医药护理	护理美容				23
		医药护理	保健与卫生				24
		交通工具	汽车相关				25
		交通工具	摩托车相关				26
		交通工具	火车相关				27
		交通工具	飞机相关				28
		房地产	建筑					29
		房地产	物业					30
		消费品	消费品				31
		商业服务	法律					32
		商业服务	会展					33
		商业服务	中介服务				34
		商业服务	认证					35
		商业服务	审计					36
		文体娱乐	传媒					37
		文体娱乐	体育					38
		文体娱乐	娱乐休闲				39
		印刷	          印刷				    40
		其它	          其它					41
	 *  	
	 */
	private static SetTempResult setIndustry(String accessToken,String industry_id1,String industry_id2){
		String reqUrl=SET_INDUSTRY.replace(token(), accessToken);
		String json="{\"industry_id1\":"+industry_id1+",\"industry_id2\":"+industry_id2+"}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, post(),json);
		SetTempResult result=(SetTempResult) JSONObject.toBean(jsonObject,SetTempResult.class);
		if(result.isSuccess()){
			logger.info("所属行业设置成功");
			return result;
		}
		logger.error("所属行业设置失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
}
