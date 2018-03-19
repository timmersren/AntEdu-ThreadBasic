package cn.rain.design.chainofresponsibility.demo3;

import cn.rain.design.chainofresponsibility.demo3.filterImpl.FaceFilterDemo3;
import cn.rain.design.chainofresponsibility.demo3.filterImpl.HtmlFilterDemo3;
import cn.rain.design.chainofresponsibility.demo3.filterImpl.SensitiveFilterDemo3;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgRequest;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgResponse;

/**
 * description: 现在在demo2的基础上我们的需求再进行升级，我们来模拟一个Servlet的拦截器简单实现。
 * 需求是这样的，在demo2中，我们已经msg字符串进行了单向链式过滤，我们就把这个过程比作用户将请求request发给
 * 服务器，然后服务器将request过滤完进行存储。我们在这个基础上，还需要服务器给用户返回一个response，
 * 这个response也需要经过过滤，但是处理过程要和request过滤时所经过的过滤器顺序相反。更通俗的说，
 * 用户的request发过来后，经过f1,f2,f3链式过滤；相反服务器返回给用户的response要经过f3,f2,f1这样顺序的链式过滤。
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MainDemo3 {
	public static void main(String[] args) {
		
		String msg = "<马化腾>不是台湾人，而是深圳人，哈哈= =，他是中国共产党党员。";
		
		FilterChainDemo3 chain = new FilterChainDemo3();
		chain.addFilter(new HtmlFilterDemo3()).addFilter(new SensitiveFilterDemo3()).addFilter(new FaceFilterDemo3());
		
		MsgRequest request = new MsgRequest();
		request.setRequestStr(msg);
		MsgResponse response = new MsgResponse();
		response.setResponseMsg("response : ");
		
		chain.dofilter(request, response, chain);
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseMsg());
	}
}
