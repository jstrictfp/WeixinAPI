package cn.jstrictfp.weixin.server.server;

import org.apache.log4j.Logger;

/**
 * @author ChengNing
 * @date   2015年1月29日
 */
public abstract class AbsServer implements IServer{

	private static Logger logger = Logger.getLogger(AbsServer.class);
	
	protected String customerServerClass;
	
	public AbsServer(){
		this.customerServerClass = getCustomerServerClass();
	}
	
	@Override
	public String token(){
		
		return customerServer().token();//返回自定义服务器的token
	}
	
	/**
	 * 加载自定义中控服务器
	 * @return 自定义的中控服务器
	 */
	public IServer customerServer(){
		String className = customerServerClass;
		IServer customerServer = null;
		try {
			Class clazz = Class.forName(className);
			customerServer = (IServer)clazz.newInstance();
		} catch (Exception e) {
			logger.error("系统找不到" + className);
			logger.error("自定义server实例化失败，" + e.getMessage());
			e.printStackTrace();
		}
		return customerServer;
	}

	/**
	 * 自定义服务器的类
	 * @return
	 */
	protected abstract String getCustomerServerClass();

}
