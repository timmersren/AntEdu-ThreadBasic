package cn.rain.design.chainofresponsibility.demo3;

import java.util.ArrayList;
import java.util.List;

import cn.rain.design.chainofresponsibility.demo3.filter.FilterDemo3;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgRequest;
import cn.rain.design.chainofresponsibility.demo3.servletparamter.MsgResponse;

/**
 * description: 
 * @author 任伟
 * @date Mar 18, 2018
 */
public class FilterChainDemo3 implements FilterDemo3{
	
	private int index = 0;
	private List<FilterDemo3> filters = new ArrayList<>();
	
	public FilterChainDemo3 addFilter(FilterDemo3 filter){
		filters.add(filter);
		return this;
	}
	
	@Override
	public void dofilter(MsgRequest request, MsgResponse response, FilterChainDemo3 fc) {
		if (index == filters.size()) {
			return;
		}
		FilterDemo3 filter = filters.get(index);
		index ++;
		filter.dofilter(request, response, fc);
	}
}
