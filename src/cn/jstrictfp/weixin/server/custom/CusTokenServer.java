package cn.jstrictfp.weixin.server.custom;

import cn.jstrictfp.weixin.server.entity.Token;
import cn.jstrictfp.weixin.server.server.TokenServer;

/**
 * 客户token 服务
 * @author Administrator
 *
 */
public abstract class CusTokenServer implements TokenServer {
	
	public String token(){
		return find();
	}
	
	/**
	 * 保存或者更新accessToken到数据库,由客户自己实现数据库插入或者更新操作
	 * 
	 * @param token   得到的token或者ticket，需要保存
	 * @return
	 */
	public abstract boolean save(Token token);
	
	/**
	 * 从数据库得到accessToken,由客户自己实现数据库的查询操作
	 * 
	 * @return
	 */
	protected abstract String find();

}
