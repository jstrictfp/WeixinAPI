package cn.jstrictfp.weixin.entity.media;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 上传临时素材返回结果
 * @author Administrator
 *
 */
public class UploadMediaResult extends Result{
	//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
    private String type;
	//媒体文件上传后，获取标识
	private String media_id;
	//媒体文件上传时间戳
	private Integer created_at;
	
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}

	public Integer getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Integer createdAt) {
		created_at = createdAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
