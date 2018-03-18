package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 定义html过滤器，将<替换成[   将>替换成]
 * @author 任伟
 * @date Mar 18, 2018
 */
public class HtmlFilter implements MsgFilter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("<", "[").replaceAll(">", "]");
	}

}
