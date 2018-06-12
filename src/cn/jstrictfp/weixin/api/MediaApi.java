package cn.jstrictfp.weixin.api;

import java.io.File;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.media.Article;
import cn.jstrictfp.weixin.entity.media.GetMediaResult;
import cn.jstrictfp.weixin.entity.media.UploadMediaResult;
import cn.jstrictfp.weixin.entity.media.UploadVideo;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 临时素材管理api
 * 1、临时素材media_id是可复用的。
   2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
   3、上传临时素材的格式、大小限制与公众平台官网一致。
	    图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	    语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	    视频（video）：10MB，支持MP4格式
	    缩略图（thumb）：64KB，支持JPG格式
   4、需使用https调用本接口。
   
 * @author Administrator
 *
 */
public class MediaApi extends Api {
	
	private static Logger logger = LoggerFactory.getLogger(MediaApi.class);
	
	//新增临时素材
	private static final String UPLOAD_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//获取临时素材
	private static final String GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	//上传图文消息内的图片获取URL
	private static final String UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	//上传图文消息素材
	private static final String UPLOAD_NEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	//上传用于群发的视频素材
	private static final String UPLOAD_VIDEO = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN";
	
	
	/**
	 * 获取临时素材
	 * @param accessToken 接口调用凭据
	 * @param mediaId 媒体文件Id
	 * 
	 */
	public static GetMediaResult getMedia(String accessToken, String mediaId) {
		String reqUrl = GET_MEDIA.replace(token(), accessToken).replace(mediaId(), mediaId);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), null);
		GetMediaResult result = (GetMediaResult) JSONObject.toBean(jsonObject, GetMediaResult.class);
		if(result.isSuccess()){
			logger.info("临时素材获取成功");
			return result;
		}
		logger.error("临时素材获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 新增临时素材
	 * @param accessToken 接口调用凭据
	 * @param type 素材类型 图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param filePath 素材完整路径
	 */
	public static UploadMediaResult uploadMedia(String accessToken, String type, String filePath) {
		String reqUrl = UPLOAD_MEDIA.replace(token(), accessToken).replace(type(), type);
		File file = new File(filePath);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, file);
		UploadMediaResult result = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(result.isSuccess()){
			logger.info("临时" + type + "素材上传成功");
			return result;
		}
		logger.error("临时" + type + "素材上传失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 上传视频素材(用于群发)
	 * 
	 * @param accessToken 接口调用凭证
	 * @param video
	 * @return
	 */
	public static UploadMediaResult uploadVideo(String accessToken, UploadVideo video) {
		String reqUrl = UPLOAD_VIDEO.replace(token(), accessToken);
		String json = JSONObject.fromObject(video).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), json);
		UploadMediaResult result = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(result.isSuccess()){
			logger.info("视频上传成功");
			return result;
		}
		 logger.error("视频上传失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 上传图文消息素材
	 * 
	 * @param accessToken 接口调用凭证
	 * @param articles 图文消息
	 * @return
	 */
	public static UploadMediaResult uploadNews(String accessToken, List<Article> articles) {
		String reqUrl = UPLOAD_NEWS.replace(token(), accessToken);
		String json = JSONObject.fromObject(articles).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		UploadMediaResult media = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(media.isSuccess()){
			logger.info("图文消息素材上传成功");
			return media;
		}
		logger.error("图文消息素材上传失败, errcode{}, errmsg{}", media.getErrcode(), media.getErrcode());
		return null;
	}
	
	/**
	 * 上传图文消息内的图片获取URL
	 * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param access_token 接口调用凭证
	 * @param file file
	 * @return UploadimgResult
	 */
	public static UploadMediaResult mediaUploadimg(String accessToken, File file) {
		String reqUrl = UPLOAD_IMG.replace(token(), accessToken);
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, file);
		UploadMediaResult media = (UploadMediaResult) JSONObject.toBean(jsonObject, UploadMediaResult.class);
		if(media.isSuccess()){
			logger.info("图文消息素材上传成功");
			return media;
		}
		logger.error("图文消息素材上传失败, errcode{}, errmsg{}", media.getErrcode(), media.getErrcode());
		return null;
	}
	
	public static void main(String[] args) {
		uploadMedia("H0rVdnVtCxTzP27qcMaqXPRTXfSOsETC-Rz6z0rc9ED1Sd6oYZqyxe2Gqn2HsEdaqpRyv5Y4YxwF56i2vPA4XzuhSYsvmRqlzsI6y9_tnSWWk8-P8g5o8J4tsUM9Qu20REPhABAYLW","image","C:\\Users\\Administrator\\Desktop\\over.jpg");
	}

}
