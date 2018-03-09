package cn.rain.thread.basic.example.threethread;

/**  
* description:有t1,t2,t3三条线程，要求t1执行完之后t2再执行，t2执行完成后t3再执行。
* 要点：线程A让线程B先执行，要在线程A内部调用threadB.join()。切记注意不要错在住线程中调用，
* 那样只是主线程等待其他线程。
* @author 任伟  
* @date Mar 8, 2018
*/
public class ThreeThread {
	public static void main(String[] args) {
		
		// t1线程
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("t1...." + i);
				}
			}
		});
		t1.start();
		
		// t2线程
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//t2线程内调用t1.join()等待t1先执行完
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("t2...." + i);
				}
			}
		});
		t2.start();
		
		// t3线程
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				//t3线程内调用t1.join()等待t2先执行完
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("t3...." + i);
				}
			}
		});
		t3.start();
		
	}
}
