package cn.jstrictfp.weixin.entity.message.preview;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片消息预览
 * 
 * @author Administrator
 *
 */
public class ImagePreview extends Preview{
	
	private Map<String,String> image;
	
	/**
	 * @param mediaId 此处的media_id与根据分组群发中的media_id相同
	 */
	public ImagePreview(String mediaId){
		 super();
		 super.setMsgtype("image");
		 this.image=new HashMap<String,String>();
		 this.image.put("media_id", mediaId);
	}

}
