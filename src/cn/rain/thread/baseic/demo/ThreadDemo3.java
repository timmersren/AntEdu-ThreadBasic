package cn.rain.thread.baseic.demo;

/**
 * 线程的创建方式3：通过匿名内部类的方式创建
 * @author admin
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		
		//其实就是省略了Demo2中通过MyThread2实现Runnable的步骤，将这一步直接写在new Thread中。
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10 ; i++) {
					System.out.println("t1 run: " + i);
				}			
			}
		}).start();
		for (int i = 0; i < 10 ; i++) {
			System.out.println("Main run: " + i);
		}	
	}
}
