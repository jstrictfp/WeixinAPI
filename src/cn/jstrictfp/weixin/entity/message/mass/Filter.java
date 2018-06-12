package cn.jstrictfp.weixin.entity.message.mass;

/**
 * 用户分组
 * 
 * @author Administrator
 *
 */
public class Filter {

	//用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
    private boolean is_to_all;
    //群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
    private String tag_id;
    
	public Filter(boolean is_to_all, String tag_id) {
		super();
		this.is_to_all = is_to_all;
		this.tag_id = tag_id;
	}

	public boolean isIs_to_all() {
		return is_to_all;
	}

	public void setIs_to_all(boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
     
     
}
