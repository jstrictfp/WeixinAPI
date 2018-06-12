package cn.jstrictfp.weixin.entity.core;

/**
 * 微信请求状态数据
 * @author Administrator
 * 
 */
public class Result {

    private static final Integer SUCCESS_CODE = 0;
    //错误码
    private Integer errcode;
    //错误信息
	private String errmsg;
	
    public Integer getErrcode() {
    	return errcode;
    }
	
    public void setErrcode(int errcode) {
	    this.errcode = errcode;
	}
	
	public String getErrmsg() {
	    return errmsg;
    }
	
	public void setErrmsg(String errmsg) {
	    this.errmsg = errmsg;
	}
	
	public boolean isSuccess() {
	    return SUCCESS_CODE.equals(errcode) || errmsg.equals("ok");
	}

}
