package cn.rain.design.proxy.demo3.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description: 具体处理方式的实现，这里实现的是记录日志的handler。
 * @author 任伟
 * @date 2018-03-22 16:50:46
 */
public class LoggerInvocationHandler implements MyInvocationHandler {
	
	private Object target;
	
	public LoggerInvocationHandler(Object target) { // 新建Handler实例的时候需要将被代理对象传入
		super();
		this.target = target;
	}

	/**
	 * @param obj 代理对象。这里没有用到，因为我们这里是简单模拟JDK的实现，在JDK中该obj会被使用到。
	 * @param method 被代理对象需要被调用的方法
	 */
	@Override
	public void invoke(Object obj, Method method) {
		System.out.println("开始记录日志..."); // 调用被代理对象的方法之前，定义该Handler的处理逻辑
		try {
			//调用被代理对象的方法，这里为了简便省略参数列表，都使用无参方法。
			method.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}  
		System.out.println("日志记录完毕..."); //调用被代理对象的方法之后，定义该Handler的处理逻辑
	}
}
