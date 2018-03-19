package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 创建一个过滤器接口，定义一个过滤规则
 * @author 任伟
 * @date Mar 18, 2018
 */
public interface MsgFilter {
	String doFilter(String msg);
}
