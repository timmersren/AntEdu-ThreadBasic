package cn.rain.thread;

public class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			System.out.println("t1 run: " + i);
		}	
	}

}
