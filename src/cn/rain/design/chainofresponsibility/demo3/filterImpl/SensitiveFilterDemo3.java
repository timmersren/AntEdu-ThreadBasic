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
public class SensitiveFilterDemo3 implements FilterDemo3{
	@Override
	public void dofilter(MsgRequest request, MsgResponse response, FilterChainDemo3 fc) {
		String tempReq = request.getRequestStr().replaceAll("中国共产党", "我党").replace("马化腾", "***").replaceAll("台湾", "")
				+ "【sensitive filter】-->";
		request.setRequestStr(tempReq);
		fc.dofilter(request, response, fc);
		response.setResponseMsg(response.getResponseMsg() + "【sensitive filter】-->");
	}
}
