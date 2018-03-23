package cn.rain.design.proxy.demo3.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description:
 * @author 任伟
 * @date 2018-03-23 15:05:06
 */
public class TransactionHandler implements MyInvocationHandler {

	private Object target;

	public TransactionHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object obj, Method method) {
		System.out.println("transaction start....");
		try {
			method.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("transaction rollback!");
			return; //如果捕捉到异常，那么会回滚事务，并且程序不再向下执行commit。
		}
		System.out.println("transaction commit...");
	}

}
