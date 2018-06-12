package cn.jstrictfp.weixin.server.timer;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import cn.jstrictfp.weixin.server.custom.CusTokenServer;
import cn.jstrictfp.weixin.server.entity.AccessToken;
import cn.jstrictfp.weixin.server.server.AccessTokenServer;

/**
 * accessToken 定时器
 */
public class AccessTokenTimer extends TimerTask{
	
	private static Logger logger = Logger.getLogger(AccessTokenTimer.class);
	
	public static final long PERIOD = 7000 * 1000;//accessToken有效期7200秒,提前200秒请求新的token
	public static final long DELAY = 0; //此任务的延迟时间为0，即立即执行

	@Override
	public void run() {
		logger.info("accessToken 定时任务启动，获取新的accessToken");
		AccessToken accessToken = new AccessToken();//得到新的access token
		if(accessToken.request()){//获取成功之后保存accessToken到数据库
			AccessTokenServer accessTokenServer = new AccessTokenServer();
			CusTokenServer customerServer = (CusTokenServer)accessTokenServer.customerServer();
			customerServer.save(accessToken);
		}
	}

}
