package cn.rain.design.proxy.demo3.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description: 具体处理方式的实现，这里实现的是记录时间的handler。
 * @author 任伟
 * @date 2018-03-22 16:49:24
 */
public class TimeInvocationHandler implements MyInvocationHandler{

	private Object target;
	
	public TimeInvocationHandler(Object target) { // 新建Handler实例的时候需要将代理对象传入
		super();
		this.target = target;
	}
	
	/**
	 * @param obj 代理对象。这里没有用到，因为我们这里是简单模拟JDK的实现，在JDK中该obj会被使用到。
	 * @param method 被代理对象需要被调用的方法
	 */
	@Override
	public void invoke(Object obj, Method method) {
		long start = System.currentTimeMillis(); // 调用被代理对象的方法之前，定义该Handler的处理逻辑
		System.out.println("开始计时...");
		try {
			//调用被代理对象的方法，这里为了简便省略参数列表，都使用无参方法。
			method.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis(); //调用被代理对象的方法之后，定义该Handler的处理逻辑
		System.out.println("方法执行结束，计时完成，共执行了 " + (end - start) + "ms");
		
	}

}
