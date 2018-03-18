package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 定义将表情符号转换的过滤器
 * @author 任伟
 * @date Mar 18, 2018
 */
public class FaceChangeFilter implements MsgFilter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("= =", "^v^");
	}

}
