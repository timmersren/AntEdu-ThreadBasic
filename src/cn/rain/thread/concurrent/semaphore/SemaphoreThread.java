package cn.rain.thread.concurrent.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * description:一个厕所只有3个坑位，但是有10个人来上厕所，那怎么办？
 * 假设10的人的编号分别为1-10，并且1号先到厕所，10号最后到厕所。
 * 那么1-3号来的时候必然有可用坑位，顺利如厕。4号来的时候需要看看前面3人是否有人出来了，
 * 如果有人出来，进去，否则等待。同样的道理，4-10号也需要等待正在上厕所的人出来后才能进去，
 * 并且谁先进去这得看等待的人是否有素质，是否能遵守先来先上的规则。
 * 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class SemaphoreThread implements Runnable {

	private String name;
	private Semaphore wc;

	public SemaphoreThread(String name, Semaphore wc) {
		this.name = name;
		this.wc = wc;
	}

	@Override
	public void run() {
		try {
			//获取设定的阈值中剩余的资源
			int availablePermits = wc.availablePermits();
			if (availablePermits > 0) {
				System.out.println(name + "有茅坑了...");
			}else {
				System.out.println(name + "没有茅坑...");
			}
			//申请资源，当剩余资源 availablePermits <= 0 时，此时线程无法申请到资源，进入阻塞等待状态
			wc.acquire();
			System.out.println(name + "轮到我上厕所了...");
			//用随机数来模拟上厕所时间
			Thread.sleep(new Random().nextInt(1000)); 
			System.out.println(name + "我上完了...茅坑给下一个人...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			wc.release();
		}
		
		
	}

}
