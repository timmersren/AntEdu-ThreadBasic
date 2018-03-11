package cn.rain.thread.security.demo;

public class VolatileThreadMain {
	public static void main(String[] args) throws InterruptedException {
		VolatileThread volatileThread = new VolatileThread();
		Thread thread = new Thread(volatileThread);
		thread.start();
		Thread.sleep(3000);
		volatileThread.setFlag(false);
		System.out.println("flag改为false");
		Thread.sleep(1000);
		System.out.println(volatileThread.flag);
	}
}
