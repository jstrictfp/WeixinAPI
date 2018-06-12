package cn.jstrictfp.weixin.entity.media;

import java.util.Arrays;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 获取临时素材返回结果
 * @author Administrator
 *
 */
public class GetMediaResult extends Result{

	//上传的临时素材名
	private String filename;
	//临时素材类型
	private String contentType;
	
	private byte[] bytes;
    
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	@Override
	public String toString() {
		return "MediaGetResult [filename=" + filename + ", contentType="
				+ contentType + ", bytes=" + Arrays.toString(bytes) + "]";
	}
	
}
