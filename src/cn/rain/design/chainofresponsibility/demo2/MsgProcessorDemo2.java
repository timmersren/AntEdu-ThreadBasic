package cn.rain.design.chainofresponsibility.demo2;

import cn.rain.design.chainofresponsibility.demo1.MsgFilter;

/**
 * description: 消息处理器，这里既然使用了过滤器链，那么和demo1中的处理不同。
 * 这里不需要再使用数组了，消息处理器需要封装两个属性，被处理者（消息）和处理者（过滤器），
 * 另外还需要封装一个处理方法。
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MsgProcessorDemo2 {
	private String msg;
	private MsgFilter filter;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MsgFilter getFilter() {
		return filter;
	}
	public void setFilter(MsgFilter filter) {
		this.filter = filter;
	}
	
	public String process(){
		return filter.doFilter(msg);
	}
	
}
