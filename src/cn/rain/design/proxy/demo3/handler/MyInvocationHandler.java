package cn.rain.design.proxy.demo3.handler;

import java.lang.reflect.Method;

/**
 * description: 处理方式的接口
 * @author 任伟
 * @date 2018-03-22 16:45:52
 */
public interface MyInvocationHandler {
	
	void invoke(Object obj, Method method);
}
