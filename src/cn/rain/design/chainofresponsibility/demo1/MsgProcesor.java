package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 消息处理器的类，这个类可以对传入的消息进行处理。
 * 最原始的思路，我们可以process方法中，由上至下的写出一个个的处理方法，
 * 但是这样做最大的缺点是，以后想增加或删除某些处理方式的时候，都要修改
 * process中的源代码。
 * 既然现在我们的处理方式是对传入的字符串进行过滤处理，那么我们不如定义这样
 * 一个过滤器的接口，在接口中定义一个规则，所有实现此接口的类都能自定义实现此
 * 规则，然后我们再把不同的过滤实现引入本类中使用。当我们需要增删改过滤方式时，
 * 仅仅操作进入的过滤器就行。
 *  
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MsgProcesor {
	
	//通过数据引入各种过滤器
	MsgFilter[] filters = {new HtmlFilter(), new SensitiveMsgFilter(), new FaceChangeFilter()};
	
	/*
	 * 然后在处理方法中引入这些过滤器进行处理，我们会发现process会变成一条链式的处理流程。
	 * 于是我们想一个问题，如果我想在这条链子的中间再插入另一条链子应该如何设计？这个问题留到Demo2
	 */
	public String process(String msg){
		String tempMsg = msg;
		for (MsgFilter msgFilter : filters) {
			tempMsg = msgFilter.doFilter(tempMsg);
		}
		return tempMsg;
	}
}
