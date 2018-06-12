package cn.jstrictfp.weixin.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 关于json的相关操作
 * @author Administrator
 *
 */
public class JSONUtil {
	
	private JSONUtil(){}

	public static <T> T parseObject(String json,Class<T> clazz){
		return JSON.parseObject(json, clazz);
	}

	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}

	/**
	 * 将JSONArray转换为数组
	 * @param ja
	 * @return
	 */
	public static Object[] toArrays(JSONArray jsonArray){  
	       Object[] objs = new Object[jsonArray.size()];  
	       for (int i = 0; i < jsonArray.size(); i++) {  
	           objs[i] = jsonArray.get(i);  
	       }  
	       return objs;  
	} 
	
	/**
	 * Json字符串转Java对象
	 * @param str 
	 * @return
	 */
	public static Object stringToObject(String str,Object object){
		if(StringUtils.isBlank(str)){
			return null;
		}
		JSONObject jsonObject=JSONObject.fromObject(str);
		Object Object= (Object)JSONObject.toBean(jsonObject,Object.class);
		return Object;
	}
	
	/***
     * JSON 转换为 List
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1},{...}]
     * @param objectClass
     * @return
     */
	public static <T> List<T> jsonToList(String jsonStr, Class<T> objectClass){  
        if (StringUtils.isNotBlank(jsonStr)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
            List<T> list = (List<T>) JSONArray.toCollection(jsonArray, objectClass);  
            return list;  
        }
        return null;
    }  
}
