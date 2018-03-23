package cn.rain.design.proxy.demo3.test;

import cn.rain.design.proxy.demo3.Step2;
import cn.rain.design.proxy.demo3.handler.TimeInvocationHandler;
import cn.rain.design.proxy.demo3.model.MyInterface;
import cn.rain.design.proxy.demo3.model.MyModel;

/**
 * description: 如果出现运行结果异常，那极有可能是因为编译缓存引起的。
 * 我们打开navigator视图，将里面生成的.class文件删除从新多运行即便就可以了。
 * @author 任伟
 * @date 2018-03-22 13:51:26
 */
public class ProxyMain {
	public static void main(String[] args) throws Exception {
		MyInterface instance = (MyInterface)Step2.newProxyInstance(MyInterface.class, new TimeInvocationHandler(new MyModel()));
		instance.run();
		System.out.println("========================");
		instance.stop();
		System.out.println("========================");
		instance.myContinue();
		System.out.println("========================");
		instance.interrupt();
	}
}
