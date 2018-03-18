package cn.rain.design.chainofresponsibility.demo2;

import cn.rain.design.chainofresponsibility.demo1.FaceChangeFilter;
import cn.rain.design.chainofresponsibility.demo1.HtmlFilter;
import cn.rain.design.chainofresponsibility.demo1.SensitiveMsgFilter;

/**
 * description: 
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MainDemo2 {
	public static void main(String[] args) {
		String msg =  "<马化腾>不是台湾人，而是深圳人，哈哈= =，他是中国共产党党员。";
		//1.创建一个过滤器链
		FilterChain f2 = new FilterChain();
		f2.addFilter(new HtmlFilter()).addFilter(new SensitiveMsgFilter());
		FilterChain f = new FilterChain();
		f.addFilter(f2).addFilter(new FaceChangeFilter()); //在过滤器链f中加入链f2
		
		//2.创建消息处理器，并传入被处理者和处理者
		MsgProcessorDemo2 processor = new MsgProcessorDemo2();
		processor.setMsg(msg);
		processor.setFilter(f);
		
		//3.启动消息处理器开始处理消息
		String result = processor.process();
		System.out.println(result);
	}
}
