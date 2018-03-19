package cn.rain.design.chainofresponsibility.demo2;

import java.util.ArrayList;
import java.util.List;

import cn.rain.design.chainofresponsibility.demo1.MsgFilter;

/**
 * description: 要完成demo1中提出的需求，我们需要有这样一个过滤器链。
 * 这个过滤器链应该具备以下特性：
 * 1.可以自由的增删过滤器。
 * 2.在增删过滤器后可以返回该过滤器链本身以方便进行链式调用。
 * 3.这个链条中还可以插入或移除其他的过滤器链，也即本类的其他对象。我们知道，
 * 该过滤器链增删过滤器的方法的参数一定是过滤器的接口，因此只要让过滤器链（即本类）
 * 实现过滤器接口就可以完成该需求，站在实际中去想，其实过滤器链也可以看成一个大的过滤器，
 * 因此让链条实现过滤器接口是没有问题的。
 * @author 任伟
 * @date Mar 18, 2018
 */
public class FilterChain implements MsgFilter{ //实现filter接口，从而可以在链条中插入链。
	
	private List<MsgFilter> filters = new ArrayList<>();
	
	public FilterChain addFilter(MsgFilter filter){
		filters.add(filter);
		return this;
	}
	
	@Override
	public String doFilter(String msg) { //执行过滤器链中的所有过滤器方法
		String temp = msg;
		for (MsgFilter msgFilter : filters) {
			temp = msgFilter.doFilter(temp);
		}
		return temp;
	}

	
}
