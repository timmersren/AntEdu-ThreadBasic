package cn.rain.thread.security.demo;

/**
 * 演示volatile关键字保证变量的可见性
 */
public class VolatileThread implements Runnable{

	//如果不使用volatile修饰变量flag，那么while循环读取的flag可能一直是本地局部内存中第一次读取的副本的值true
//	public boolean flag = true;
	
	//使用volatile修饰，flag只要一修改，立即对其他线程可见，立刻刷新到主内存中，并强制要求线程每次都从主内存中读取，而不是从本地局部内存读取
	public volatile boolean flag = true;
	
	@Override
	public void run() {
		System.out.println("子线程开始执行...");
		while(flag){
		}
		System.out.println("子线程执行结束...");
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
