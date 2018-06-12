package cn.jstrictfp.weixin.entity.message.customservice;

/**
 * 发送小程序卡片
 * @author Administrator
 *
 */
public class MiniProgramMessage extends Message{
	
	private MiniProgram mini;

	public MiniProgramMessage(String touser) {
		super(touser, "miniprogrampage");
	}
	
	public MiniProgramMessage(String touser,MiniProgram mini){
		this(touser);
		this.mini=mini;
	}
	
	public MiniProgram getMini() {
		return mini;
	}

	public void setMini(MiniProgram mini) {
		this.mini = mini;
	}

}
