package cn.rain.design.proxy.demo3.model;

/**
 * description:
 * @author 任伟
 * @date 2018-03-22 15:15:36
 */
public class MyModel implements MyInterface {

	@Override
	public void run() {
		System.out.println("我运行了....");
	}

	@Override
	public void stop() {
		System.out.println("我停止了.....");
	}

	@Override
	public void myContinue() {
		System.out.println("我继续了...");
	}

	@Override
	public void interrupt() {
		System.out.println("我中断了....");
	}

}
