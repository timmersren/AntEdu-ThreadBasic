package cn.rain.design.chainofresponsibility.demo3.filterImpl;

import cn.rain.design.chainofresponsibility.demo3.FilterChainDemo3;
import cn.rain.design.chainofresponsibility.demo3.filter.FilterDemo3;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgRequest;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgResponse;

/**
 * description: 
 * @author 任伟
 * @date Mar 18, 2018
 */
public class HtmlFilterDemo3 implements FilterDemo3{
	@Override
	public void dofilter(MsgRequest request, MsgResponse response, FilterChainDemo3 fc) {
		String htmlTemp = request.getRequestStr().replaceAll("<", "[").replaceAll(">", "]") + "【html filter】-->";
		request.setRequestStr(htmlTemp);
		fc.dofilter(request, response, fc);
		response.setResponseMsg(response.getResponseMsg() + "【html filter】-->");
	}
}
