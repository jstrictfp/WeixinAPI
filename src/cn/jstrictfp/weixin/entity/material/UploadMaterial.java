package cn.jstrictfp.weixin.entity.material;

/**
 * 永久素材
 * @author Administrator
 *
 */
public class UploadMaterial {
	
	//视频标题
	private String title;
	//视频描述
	private String introduction;
	//素材类型
	private String type;
	//素材路径
	private String filePath;
	
	public UploadMaterial(String type,String filePath) {
		super();
		this.type=type;
		this.filePath=filePath;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
