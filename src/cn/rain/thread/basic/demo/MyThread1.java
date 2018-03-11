package cn.rain.thread.basic.demo;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			System.out.println("t1 run: " + i);
		}
	}
	
	
}
