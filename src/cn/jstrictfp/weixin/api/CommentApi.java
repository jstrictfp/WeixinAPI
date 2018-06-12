package cn.jstrictfp.weixin.api;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.comment.CommentList;
import cn.jstrictfp.weixin.entity.comment.CommentListResult;
import cn.jstrictfp.weixin.entity.comment.MarkeLect;
import cn.jstrictfp.weixin.entity.comment.OpenComment;
import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 评论管理api
 * @author Administrator
 *
 */
public class CommentApi extends Api {
	
	private static Logger logger = LoggerFactory.getLogger(CommentApi.class);
	//打开已群发文章评论 
	private static final String OPEN_COMMENT = "https://api.weixin.qq.com/cgi-bin/comment/open?access_token=ACCESS_TOKEN";
	//关闭已群发文章评论 
	private static final String CLOSE_COMMENT = "https://api.weixin.qq.com/cgi-bin/comment/close?access_token=ACCESS_TOKEN";
	//查看指定文章的评论数据
	private static final String LIST_COMMENT = "https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN";
	//将评论标记精选
	private static final String MARKELECT_COMMENT = "https://api.weixin.qq.com/cgi-bin/comment/markelect?access_token=ACCESS_TOKEN";
	//将评论取消精选
	private static final String UN_MARKELECT_COMMENT = "https://api.weixin.qq.com/cgi-bin/comment/unmarkelect?access_token=ACCESS_TOKEN";
	//删除评论
	private static final String DELETE_COMMMENT = "https://api.weixin.qq.com/cgi-bin/comment/delete?access_token=ACCESS_TOKEN";
	//回复评论
	private static final String ADD_REPLY = "https://api.weixin.qq.com/cgi-bin/comment/reply/add?access_token=ACCESS_TOKEN";
	//删除回复
	private static final String DELETE_REPLY = "https://api.weixin.qq.com/cgi-bin/comment/reply/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * 删除回复
	 * @param accessToken 接口调用凭据
	 * @param mark 
	 * @return
	 */
	public static Result delReply(String accessToken, MarkeLect mark) {
		String reqUrl = DELETE_REPLY.replace(token(), accessToken);
		String json = JSONObject.fromObject(mark).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("回复删除成功");
			return result;
		}
		logger.error("回复删除失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 回复评论
	 * @param accessToken 接口调用凭据
	 * @param mark 
	 * @return
	 */
	public static Result replyComment(String accessToken, MarkeLect mark) {
		String reqUrl = ADD_REPLY.replace(token(), accessToken);
		String json = JSONObject.fromObject(mark).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result= (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("评论回复成功");
			return result;
		}
		logger.error("评论回复失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 删除评论
	 * @param accessToken 接口调用凭据
	 * @param mark 
	 * @return
	 */
	public static Result delComment(String accessToken, MarkeLect mark) {
		String reqUrl = DELETE_COMMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(mark).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("评论删除成功");
			return result;
		}
		logger.error("评论删除失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 将评论取消精选
	 * @param accessToken 接口调用凭据
	 * @param mark 
	 * @return
	 */
	public static Result unMarkelectComment(String accessToken,MarkeLect mark) {
		String reqUrl = UN_MARKELECT_COMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(mark).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("精选评论标记取消成功");
			return result;
		}
		logger.error("精选评论标记取消失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 将评论标记精选
	 * @param accessToken 接口调用凭据
	 * @param mark 
	 * @return
	 */
	public static Result markelectComment(String accessToken, MarkeLect mark) {
		String reqUrl = MARKELECT_COMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(mark).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("精选评论标记成功");
			return result;
		}
		logger.error("精选评论标记失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 获取指定文章的评论
	 * @param accessToken 接口调用凭证
	 * @param cl
	 * @return
	 */
	public static CommentListResult getCommentList(String accessToken, CommentList cl) {
		String reqUrl = LIST_COMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(cl).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		CommentListResult result= (CommentListResult) JSONObject.toBean(jsonObject, CommentListResult.class);
		if(result.isSuccess()){
			logger.info("文章评论关闭成功");
			return result;
		}
		logger.error("文章评论关闭失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 关闭文章评论
	 * @param accessToken 接口调用凭据
	 * @param c 关闭评论的文章
	 * @return
	 */
	public static Result closeComment(String accessToken, OpenComment c) {
		String reqUrl = CLOSE_COMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(c).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("文章评论关闭成功");
			return result;
		}
		logger.error("文章评论关闭失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}
	
	/**
	 * 开启文章评论
	 * @param accessToken 接口调用凭据
	 * @param c 开启评论的文章
	 * @return
	 */
	public static Result openComment(String accessToken, OpenComment c) {
		String reqUrl = OPEN_COMMENT.replace(token(), accessToken);
		String json = JSONObject.fromObject(c).toString();
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
		if(result.isSuccess()){
			logger.info("文章评论开启成功");
			return result;
		}
		logger.error("文章评论开启失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return null;
	}

}
