package cn.rain.design.chainofresponsibility.demo3.filter;

import cn.rain.design.chainofresponsibility.demo3.FilterChainDemo3;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgRequest;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgResponse;

/**
 * description: 过滤器要能接受request，还要能返回response，还要控制过滤器顺序。
 * 因此由三个参数。
 * @author 任伟
 * @date Mar 18, 2018
 */
public interface FilterDemo3 {
	void dofilter(MsgRequest request, MsgResponse response, FilterChainDemo3 fc);
}
