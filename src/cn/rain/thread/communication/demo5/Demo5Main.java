package cn.rain.thread.communication.demo5;

/**
 * description: ThreadLocal的原理就是利用Map的key存入currentThread（当前线程的唯一标识），
 * value存入Object（任意类型的对象），来创造一个线程私有的数据存储区。
 * @author 任伟
 * @date Mar 11, 2018
 */
public class Demo5Main {
	public static void main(String[] args) {
//		CountDemo demo = new CountDemo();
		ThreadLocalDemo demo = new ThreadLocalDemo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		Thread t3 = new Thread(demo);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
