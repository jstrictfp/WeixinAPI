package cn.jstrictfp.weixin.entity.message.mass;

import cn.jstrictfp.weixin.entity.core.Result;

/**
 * 群发速度
 * speed	realspeed
	0	80w/分钟
	1	60w/分钟
	2	45w/分钟
	3	30w/分钟
	4	10w/分钟
 * @author Administrator
 *
 */
public class MassSpeedResult extends Result {
	
	//群发速度的级别
	private int speed;
	//群发速度的真实值 单位：万/分钟
    private int realspeed;
    
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRealspeed() {
		return realspeed;
	}
	public void setRealspeed(int realspeed) {
		this.realspeed = realspeed;
	}

}
