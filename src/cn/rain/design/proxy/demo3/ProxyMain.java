package cn.rain.design.proxy.demo3;

import cn.rain.design.proxy.demo3.model.MyInterface;

/**
 * description:
 * @author 任伟
 * @date 2018-03-22 13:51:26
 */
public class ProxyMain {
	public static void main(String[] args) throws Exception {
		MyInterface instance = (MyInterface)Step1.newProxyInstance(MyInterface.class);
		instance.run();
		System.out.println("========================");
		instance.stop();
		System.out.println("========================");
		instance.myContinue();
		System.out.println("========================");
		instance.interrupt();
	}
}
