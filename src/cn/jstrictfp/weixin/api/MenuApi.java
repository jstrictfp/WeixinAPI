package cn.jstrictfp.weixin.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;
import cn.jstrictfp.weixin.entity.core.Result;
import cn.jstrictfp.weixin.entity.menu.add.MenuButtons;
import cn.jstrictfp.weixin.entity.menu.add.MenuResult;
import cn.jstrictfp.weixin.entity.menu.conditional.ConditionalMenu;
import cn.jstrictfp.weixin.entity.menu.conditional.ConditionalMenuResult;
import cn.jstrictfp.weixin.entity.menu.conditional.TryMatchResult;
import cn.jstrictfp.weixin.entity.menu.config.CurrentMenuInfo;
import cn.jstrictfp.weixin.util.HttpUtil;
import cn.jstrictfp.weixin.util.JSONUtil;

/**
 * 自定义菜单接口
 * 
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，
 * 如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * 
 * @author Administrator
 *
 */
public class MenuApi extends Api{
	
	private static Logger logger = LoggerFactory.getLogger(MenuApi.class);
	
	//创建菜单接口链接（POST）
	private static final String CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//菜单查询接口（GET）
	private static final String GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	//菜单删除接口（GET）
	private static final String DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//创建个性菜单 （POST）
	private static final String ADD_CONDITIONAL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	//删除个性菜单 （GET）
	private static final String DEL_CONDITIONAL = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	//测试个性化菜单匹配结果 （GET）
	private static final String TRY_MATCH = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
	//获取自定义菜单配置接口
	private static final String GET_CURRENT_SELFMENU_INFO = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建菜单
	 * @param menu 菜单实例
	 * @param accessToken 接口凭证
	 * @return true|false 
	 */
	public static Result createMenu(String accessToken, MenuButtons menu) {
		String requestUrl = CREATE.replace(token(), accessToken);
		//将菜单对象转换成JSON字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		//发起POST请求创建菜单
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, post(), jsonMenu);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("创建菜单成功");
    		return result;
    	}
    	logger.error("创建菜单失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
	}
	
	/**
	 * 查询菜单
	 * @param accessToekn 接口凭证
	 * @return  菜单的json字符串
	 */
	public static MenuResult getMenu(String accessToekn) {
		String reqUrl = GET.replace(token(), accessToekn);
		//发起GET请求查询菜单
		JSONObject jsonObject = HttpUtil.httpsRequest(reqUrl, get(), null);
		MenuResult result = (MenuResult) JSONObject.toBean(jsonObject,MenuResult.class);
		if(result.isSuccess()) {
			logger.info("自定义菜单获取成功");
			return result;
		}
		logger.error("自定义菜单获取失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
		return result;
	}
	
	/**
	 * 删除菜单 
	 * @param accessToken 接口凭证
	 * @return  true|false
	 */
	public static Result deleteMenu(String accessToken) {
		String requestUrl = DELETE.replace(token(), accessToken);
		//发起GET请求删除菜单
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, get(), null);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("删除菜单成功");
    		return result;
    	}
    	logger.error("删除菜单失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
	}
	
	/**
	 * 测试个性化菜单匹配结果
	 * @param accessToken 接口凭据
	 * @param userId 粉丝的openId或者微信号
	 * @return
	 */
	public static TryMatchResult tryMath(String accessToken, String userId) {
		String requestUrl = TRY_MATCH.replace(token(), accessToken);
		String json = "{\"user_id\":\"" + userId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, post(), json);
		String menuStr = jsonObject.toString();
		TryMatchResult menu = (TryMatchResult) JSONUtil.stringToObject(menuStr, TryMatchResult.class);
		if(menu.isSuccess()){
    		logger.info("个性化菜单匹配成功");
    		return menu;
    	}
    	logger.error("个性化菜单匹配失败, errcode{}, errmsg{}", menu.getErrcode(), menu.getErrcode());
    	return null;
	}
	
	/**
	 * 创建个性化菜单
	 * @param accessToken 
	 * @param selfMenu 
	 * @return
	 */
    public static ConditionalMenuResult addConditional(String accessToken, ConditionalMenu selfMenu) {
    	String requestUrl = ADD_CONDITIONAL.replace(token(), accessToken);
    	//将菜单对象转换成json字符串
    	String jsonSelfMenu = JSONObject.fromObject(selfMenu).toString(); 
    	JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, post(), jsonSelfMenu);
    	ConditionalMenuResult result = (ConditionalMenuResult) JSONObject.toBean(jsonObject, ConditionalMenuResult.class);
    	if(result.isSuccess()){
    		logger.info("个性化菜单创建成功");
    		return result;
    	}
    	logger.error("个性化菜单创建失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
    }
    
    /**
	 * 删除个性菜单
	 * @param accessToken
	 * @param menuId 菜单id：可通过查询菜单接口获得
	 * @return
	 */
	public static Result delConditional(String accessToken, String menuId) {
		String requestUrl = DEL_CONDITIONAL.replace(token(), accessToken);
		String json = "{\"menuid\":\"" + menuId + "\"}";
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, post(), json);
		Result result = (Result) JSONObject.toBean(jsonObject, Result.class);
    	if(result.isSuccess()){
    		logger.info("删除菜单成功");
    		return result;
    	}
    	logger.error("删除菜单失败, errcode{}, errmsg{}", result.getErrcode(), result.getErrcode());
    	return null;
	}
	
	/**
	 * 获取自定义菜单配置
	 * @param accessToken
	 * @return
	 */
	public static CurrentMenuInfo getCurrentSelfInfo(String accessToken) {
		String requestUrl = GET_CURRENT_SELFMENU_INFO.replace(token(), accessToken);
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, get(), null);
		CurrentMenuInfo currentMenuInfo = (CurrentMenuInfo) JSONObject.toBean(jsonObject, Result.class);
		if(currentMenuInfo.isSuccess()){
    		logger.info("菜单配置获取成功");
    		return currentMenuInfo;
    	}
    	logger.error("菜单配置获取失败, errcode{}, errmsg{}", currentMenuInfo.getErrcode(), currentMenuInfo.getErrcode());
    	return null;
	}
}
