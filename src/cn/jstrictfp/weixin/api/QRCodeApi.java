package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.qr.QRCodeResult;
import cn.jstrictfp.weixin.util.CommonUtil;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 公众号账号管理Api
 * @author Administrator
 *
 */
public class QRCodeApi extends Api {
	
	private static Logger log = LoggerFactory.getLogger(UserTagApi.class);
	//生成带参数的二维码
	private static final String CREATE_QRCODE="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    //换取二维码图片
	private static final String SHOW_QRCODE="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	/**
	 * 生成临时带参数（int类型）二维码
	 * @param accessToken 接口调用凭据
	 * @param expire 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return
	 */
	public static QRCodeResult createQRCode(String accessToken,int expire,int sceneId){
		
		String json="{\"expire_seconds\":\""+expire+"\", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":\""+sceneId+"\"}}}";
		
		return createQRCode(accessToken,json);
	}
	
	/**
	 * 生成临时带参数（String类型）二维码
	 * @param accessToken 接口调用凭据
	 * @param expire 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64  
	 * @return
	 */
	public static QRCodeResult createQRCode(String accessToken,int expire,String sceneStr){
		
		String json="{\"expire_seconds\":\""+expire+"\", \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\""+sceneStr+"\"}}}";
		
		return createQRCode(accessToken,json);
	}
	
	/**
	 * 生成永久带参数（int类型）二维码
	 * @param accessToken 接口调用凭据
	 * @param expire 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return 
	 */
	public static QRCodeResult createLimitQRCode(String accessToken,int sceneId){
		
		String json="{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":\""+sceneId+"\"}}}";
		
		return createQRCode(accessToken,json);
	}
	
	/**
	 * 生成永久带参数（String类型）二维码
	 * @param accessToken 接口调用凭据
	 * @param expire 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64  
	 * @return
	 */
	public static QRCodeResult createLimitQRCode(String accessToken,String sceneStr){
		
		String json="{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\""+sceneStr+"\"}}}";
		
		return createQRCode(accessToken,json);
	}
	
	private static QRCodeResult createQRCode(String accessToken,String json){
		String reqUrl=CREATE_QRCODE.replace(token(), accessToken);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",json);
		QRCodeResult result=(QRCodeResult) JSONObject.toBean(jsonObject,QRCodeResult.class);
		if(result.isSuccess()){
			log.info("临时带参数二维码获取成功");
			return result;
		}
		log.error("临时带参数二维码获取失败，errcode:{},errmsg:{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 换取二维码
	 * @param ticket 由生成二维码接口取得
	 * @param filePath
	 */
	public static void showQRCode(String ticket, String filePath){
		String resUrl=SHOW_QRCODE.replace("TICKET",CommonUtil.urlEncodeUTF8(ticket));
		HttpUtil.downImage(resUrl,filePath,ticket);
	}
	
	public static void main(String[] args) {
		showQRCode("","D:/");
	}
}
