package cn.jstrictfp.weixin.entity.message.mass;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片消息
 * @author Administrator
 *
 */
public class ImageMassMessage extends MassMessage{
	
	private Map<String,String>  image;
	
	/**
	 * 此处media_id需通过基础支持中的上传下载多媒体文件来得到
	 * @param mediaId
	 */
	public ImageMassMessage(String mediaId){
		super("image");
		this.image=new HashMap<String,String>();
		this.image.put("media_id", mediaId);
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}
	
}
