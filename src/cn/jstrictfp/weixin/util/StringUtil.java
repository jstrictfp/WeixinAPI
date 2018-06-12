package cn.jstrictfp.weixin.util;

public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null){
			return true;
		}
		if(str.isEmpty() || str==""){
			return true;
		}
		return false;
	}
}
