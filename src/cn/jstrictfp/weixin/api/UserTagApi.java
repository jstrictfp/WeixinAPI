package cn.jstrictfp.weixin.api;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.tag.CreateTagResult;
import cn.jstrictfp.weixin.entity.tag.TagListResult;
import cn.jstrictfp.weixin.entity.tag.TagUsersResult;
import cn.jstrictfp.weixin.entity.tag.UserTagsResult;
import cn.jstrictfp.weixin.util.HttpUtil;

/**
 * 用户标签管理Api
 * @author Administrator
 *
 */
public class UserTagApi extends Api{
	
	private static Logger log = LoggerFactory.getLogger(UserTagApi.class);
	//创建标签
	private static final String CREATE_TAG="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
	//获取已经创建的标签
	private static final String GET_TAGS="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
	//编辑标签
	private static final String UPDATE_TAG="https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";
	//删除标签
	private static final String DELETE_TAG="https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
	//获取标签下的粉丝列表
	private static final String GET_TAG_USERS="https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
    //批量为用户打标签
	private static final String BATCH_ADD_TAG="https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
	//批量为用户取消标签
	private static final String BATCH_CANCEL_TAG="https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
	//获取用户身上的标签列表
	private static final String GET_USER_TAGS="https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
	
	/**
	 * 批量为用户添加标签
	 * @param accessToken 接口调用凭据
	 * @param tagId 标签编号
	 * @param openIdList 用户openid列表
	 * @return
	 */
	public static Result batchAddTag(String accessToken,int tagId,List<String> openIdList){
		String reqUrl=BATCH_ADD_TAG.replace(token(), accessToken);
		StringBuffer str=new StringBuffer();
		str.append("{\"openid_list\":[");
		for(int i=0;i<openIdList.size();i++){
			str.append("\"").append(openIdList.get(i)).append("\"").append(i==openIdList.size()-1?"":",");
		}
		str.append("],");
		str.append("\"tagid\":\""+tagId+"\"");
		str.append("}");
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",str.toString());
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("用户批量添加标签成功");
			return result;
		}
		log.error("用户批量添加标签失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 批量为用户取消标签
	 * @param accessToken 接口调用凭据
	 * @param tagId 标签编号
	 * @param openIdList 用户openid列表
	 * @return
	 */
	public static Result batchCancelTag(String accessToken,int tagId,List<String> openIdList){
		String reqUrl=BATCH_CANCEL_TAG.replace(token(), accessToken);
		StringBuffer str=new StringBuffer();
		str.append("{\"openid_list\":[");
		for(int i=0;i<openIdList.size();i++){
			str.append("\"").append(openIdList.get(i)).append("\"").append(i==openIdList.size()-1?"":",");
		}
		str.append("],");
		str.append("\"tagid\":\""+tagId+"\"");
		str.append("}");
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",str.toString());
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("用户批量取消标签成功");
			return result;
		}
		log.error("用户批量取消标签失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取用户身上的标签列表
	 * @param accessToken 接口调用凭据
	 * @param openId 用户在公众号的openid
	 * @return
	 */
	public static UserTagsResult getUserTags(String accessToken,String openId){
		String reqUrl=GET_USER_TAGS.replace(token(), accessToken);
		String json="{\"openid\":\""+openId+"\"}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",json);
		UserTagsResult result=(UserTagsResult) JSONObject.toBean(jsonObject, UserTagsResult.class);
		if(result.isSuccess()){
			log.info("用户标签列表获取成功");
			return result;
		}
		log.error("用户标签列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 创建标签
	 * 一个公众号，最多可以创建100个标签。
	 * @param accessToken  接口调用凭据
	 * @param name 标签名（30个字符以内）
	 * @return
	 */
	public static CreateTagResult addTag(String accessToken,String name){
		String reqUrl=CREATE_TAG.replace(token(), accessToken);
		String json="{\"tag\":{\"name\":\""+name+"\"}}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",json);
		CreateTagResult result=(CreateTagResult) JSONObject.toBean(jsonObject,CreateTagResult.class);
		if(result.isSuccess()){
			log.info("标签创建成功");
			return result;
		}
		log.error("标签创建失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取公众号的标签列表
	 * @param accessToken 接口调用凭据
	 * @return
	 */
	public static TagListResult getTagList(String accessToken){
		String reqUrl=GET_TAGS.replace(token(), accessToken);
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",null);
		TagListResult result=(TagListResult) JSONObject.toBean(jsonObject,TagListResult.class);
		if(result.isSuccess()){
			log.info("标签列表获取成功");
			return result;
		}
		log.error("标签列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 编辑标签
	 * @param accessToken 接口调用凭据
	 * @param tagId 标签编号
	 * @param name 标签名，UTF8编码
	 * @return
	 */
	public static Result updateTag(String accessToken,int tagId,String name){
		String reqUrl=UPDATE_TAG.replace(token(), accessToken);
		String json = "{\"tag\":{\"id\":\""+tagId+"\",\"name\":\""+name+"\"}}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",json);
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("标签修改成功");
			return result;
		}
		log.error("标签修改失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 删除标签
	 * @param accessToken 接口调用凭据
	 * @param tagId 标签编号
	 * @return
	 */
	public static Result deleteTag(String accessToken,int tagId){
		String reqUrl=DELETE_TAG.replace(token(), accessToken);
		String json = "{\"tag\":{\"id\":\""+tagId+"\"}}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "POST",json);
		Result result=(Result) JSONObject.toBean(jsonObject,Result.class);
		if(result.isSuccess()){
			log.info("标签删除成功");
			return result;
		}
		log.error("标签删除失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	/**
	 * 获取标签下粉丝列表
	 * @param accessToken 接口调用凭证
	 * @param tagId 标签id
	 * @param nextOpenId 第一个拉取的OPENID，不填默认从头开始拉取
	 * @return
	 */
	public static TagUsersResult getTagUser(String accessToken,int tagId,String nextOpenId){
		String reqUrl=GET_TAG_USERS.replace(token(),accessToken);
		String json="{\"tagid\":\""+tagId+"\",\"next_openid\":\""+nextOpenId+"\"}";
		JSONObject jsonObject=HttpUtil.httpsRequest(reqUrl, "GET",json);
		TagUsersResult result=(TagUsersResult) JSONObject.toBean(jsonObject,TagUsersResult.class);
		if(result.isSuccess()){
			log.info("标签下粉丝列表获取成功");
			return result;
		}
		log.error("标签下粉丝列表获取失败，errcode{},errmsg{}",result.getErrcode(),result.getErrcode());
		return null;
	}
	
	public static void main(String[] args) {
		String token="B9A_GQqfZl9pJx7jPaTFi8MwLjklQfPo7MjleVMNlOrz1oxFbVrf0CEzEUyiRFnh6zDHeYNM2vxxjeZlJ4huigOOAJVZyup5vklpo6lO5szs9n-pf3oTld1EdHZFI_CBEMHiADAJRM";
		String name="小客户"; 
		System.out.println("创建标签："+addTag(token,name));
	}
	
}
