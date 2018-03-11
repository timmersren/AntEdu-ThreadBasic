package cn.rain.thread.communication.demo5;

/**
 * description: 
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ThreadLocalDemo implements Runnable {

	private int count= 0;

	//使用threadLocal的时候，将数据初始化为0
	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 0;
		};
	};
		
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			Integer localCount = threadLocal.get();
			count = localCount + 1;
			System.out.println(Thread.currentThread().getName() + "-- count:" + count);
			threadLocal.set(count);
		}
	}

}
