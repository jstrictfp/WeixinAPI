package cn.jstrictfp.weixin.server.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import cn.jstrictfp.weixin.server.timer.AccessTokenTimer;

/**
 * token 监听器
 * @author Administrator
 *
 */
public class TokenListener implements ServletContextListener{
	
    private static Logger log = Logger.getLogger(TokenListener.class);
    
	private Timer timer = null;
    
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("accessToken监听器启动:");
		timer = new Timer(true);
		registeAccessTokenTimer();//注册token定时器
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}
	
	/**
	 * 注册accessToken定时器
	 */
	private void registeAccessTokenTimer(){
		AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
		timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY,AccessTokenTimer.PERIOD);
		log.info("accessToken定时器注册成功，时间间隔为" + AccessTokenTimer.PERIOD+"ms");
	}
	
}
