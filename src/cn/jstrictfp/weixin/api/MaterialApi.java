 package cn.jstrictfp.weixin.api;

import java.io.File;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.material.Articles;
import cn.jstrictfp.weixin.entity.material.GetArticleResult;
import cn.jstrictfp.weixin.entity.material.GetArticlesResult;
import cn.jstrictfp.weixin.entity.material.GetMaterial;
import cn.jstrictfp.weixin.entity.material.GetMaterialResult;
import cn.jstrictfp.weixin.entity.material.GetMaterialCountResult;
import cn.jstrictfp.weixin.entity.material.GetMaterialsResult;
import cn.jstrictfp.weixin.entity.material.GetVideoResult;
import cn.jstrictfp.weixin.entity.material.UpdateArticle;
import cn.jstrictfp.weixin.entity.material.UploadMaterial;
import cn.jstrictfp.weixin.entity.media.UploadMediaResult;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 永久素材管理
 *  1、永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
	2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000。
	3、素材的格式大小等要求与公众平台官网一致：
	    图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
	    语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
	    视频（video）：10MB，支持MP4格式
	    缩略图（thumb）：64KB，支持JPG格式
	4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片url需通过"上传图文消息内的图片获取URL"接口上传图片获取。
	5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的5000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
	6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
 * @author Administrator
 *
 */
public class MaterialApi extends Api {

	private static Logger logger = LoggerFactory.getLogger(MaterialApi.class);
	//新增永久图文素材
	private static final String ADD_NEWS_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	//新增其他类型（除图文消息外）的永久素材
	private static final String ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	//获取永久素材
	private static final String GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	//删除永久素材
	private static final String DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	//修改永久图文素材
	private static final String UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	//获取永久素材总数
	private static final String GET_MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	//获取永久素材列表
	private static final String GET_MATERIAL_LIST = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取图文素材列表
	 * @param accessToken 接口调用凭据
	 * @param material  
	 * @return
	 */
	public static GetArticlesResult getArticles(String accessToken, GetMaterial material) {
		String reqUrl = GET_MATERIAL_LIST.replace(token(), accessToken);
		String json = JSONObject.fromObject(material).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetArticlesResult result = (GetArticlesResult) JSONObject.toBean(jsonObject, GetArticlesResult.class);
		if(result.isSuccess()){
			logger.info("永久图文素材列表获取成功");
			return result;
		}
		logger.error("永久图文素材列表获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取其他永久素材列表
	 * @param accessToken 接口调用凭据
	 * @param material
	 * @return
	 */
	public static GetMaterialsResult getMaterials(String accessToken, GetMaterial material) {
		String reqUrl = GET_MATERIAL_LIST.replace(token(), accessToken);
		String json = JSONObject.fromObject(material).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetMaterialsResult result = (GetMaterialsResult) JSONObject.toBean(jsonObject, GetMaterialsResult.class);
		if(result.isSuccess()){
			logger.info("永久素材列表获取成功");
			return result;
		}
		logger.error("永久素材列表获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取永久素材总数 
	 * @param accessToken 接口调用凭据
	 * @return
	 */
	public static GetMaterialCountResult getMaterialCount(String accessToken) {
		String reqUrl = GET_MATERIAL_COUNT.replace(token(), accessToken);
		String json = null;
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetMaterialCountResult result = (GetMaterialCountResult) JSONObject.toBean(jsonObject, GetMaterialCountResult.class);
		if(result.isSuccess()){
			logger.info("永久素材总数获取成功");
			return result;
		}
		logger.error("永久素材总数获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 修改永久图文素材
	 * @param accessToken 接口调用凭据
	 * @param update 要修改的文章内容
	 * @return 
	 */
	public static Result updateNews(String accessToken, UpdateArticle update) {
		String reqUrl = UPDATE_NEWS.replace(token(), accessToken);
		String json = JSONObject.fromObject(update).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("永久图文素材修改成功");
			return result;
		}
		logger.error("永久图文素材修改失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 删除永久素材
	 * @param accessToken 接口调用凭据
	 * @param mediaId 媒体文件Id
	 * @return
	 */
	public static Result delMaterial(String accessToken, String mediaId) {
		String reqUrl = DEL_MATERIAL.replace(token(), accessToken);
		String json = "{\"media_id\":\"" + mediaId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("永久图文素材删除成功");
			return result;
		}
		logger.error("永久图文素材删除失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取永久图文素材
	 * @param accessToken
	 * @return
	 */
	public static GetArticleResult getArticle(String accessToken,String mediaId) {
		String reqUrl = GET_MATERIAL.replace(token(), accessToken);
		String json = "{\"media_id\":\"" + mediaId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetArticleResult result = (GetArticleResult) JSONObject.toBean(jsonObject, GetArticleResult.class);
		if(result.isSuccess()){
			logger.info("永久图文素材获取成功");
			return result;
		}
		logger.error("永久图文素材获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取永久视频素材
	 * @param accessToken 接口调用凭据
	 * @return
	 */
	public static GetVideoResult getVideo(String accessToken, String mediaId) {
		String reqUrl = GET_MATERIAL.replace(token(), accessToken);
		String json = "{\"media_id\":\"" + mediaId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetVideoResult result = (GetVideoResult) JSONObject.toBean(jsonObject, GetVideoResult.class);
		if(result.isSuccess()){
			logger.info("永久视频素材获取成功");
			return result;
		}
		logger.error("永久视频素材获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取其他类型的永久素材
	 * 
	 * @param accessToken 接口调用凭据
	 * @return
	 */
	public static GetMaterialResult getMaterial(String accessToken, String mediaId) {
		String reqUrl = GET_MATERIAL.replace(token(), accessToken);
		String json = "{\"media_id\":\"" + mediaId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		GetMaterialResult result = (GetMaterialResult) JSONObject.toBean(jsonObject, GetMaterialResult.class);
		if(result.isSuccess()){
			logger.info("永久素材获取成功");
			return result;
		}
		logger.error("永久素材获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 新增永久图文素材
	 * @param accessToken 接口调用凭据
	 * @param articles 图文素材
	 * @return
	 */
	public static UploadMediaResult uploadNews(String accessToken, Articles articles) {
		String reqUrl = ADD_NEWS_MATERIAL.replace(token(), accessToken);
		String json = JSONObject.fromObject(articles).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		UploadMediaResult result = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(result.isSuccess()){
			logger.info("永久图文消息素材上传成功");
			return result;
		}
		logger.error("永久图文消息素材上传失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 新增其他永久素材
	 * @param accessToken 接口调用凭据
	 * @param type 素材类型
	 * @param filpath 素材完整路径
	 * @return
	 */
	public static UploadMediaResult uploadMaterial(String accessToken, UploadMaterial material) {
		String reqUrl = ADD_MATERIAL.replace(token(), accessToken).replace(type(), material.getType());
		File file = new File(material.getFilePath());
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, file);
		UploadMediaResult result = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(result.isSuccess()){
			logger.info("永久" + material.getType() + "素材上传成功");
			return result;
		}
		logger.error("永久" + material.getType() + "素材上传失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
}
