package cn.jstrictfp.weixin.entity.comment;

/**
 * 查看指定文章的评论数据的返回结果
 * 
 * @author Administrator
 *
 */
public class CommentList extends OpenComment{

	//起始位置
	private int begin;
	//获取数目（>=50会被拒绝）
	private int count;
	/*
	 *  type=0 普通评论&精选评论
		type=1  普通评论
		type=2 精选评论
	 */
	private int type;
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
