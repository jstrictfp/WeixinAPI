package cn.jstrictfp.weixin.api;

public abstract class Api {
	
private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	
	private static final String GET = "GET";
	
	private static final String POST = "POST";
	
	private static final String TYPE = "TYPE";
	
	private static final String MEDIA_ID = "MEDIA_ID";
	
	private static final String KFACCOUNT="KFACCOUNT";
	
	public static String token() {
		return ACCESS_TOKEN;
	}
	
	public static String get() {
		return GET;
	}
	
	public static String post() {
		return POST;
	}
	
	public static String type() {
		return TYPE;
	}
	
	public static String mediaId() {
		return MEDIA_ID;
	}
	
	public static String kfAccount() {
		return KFACCOUNT;
	}
	
}
