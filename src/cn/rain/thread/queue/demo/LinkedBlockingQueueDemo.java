package cn.rain.thread.queue.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description: LinkedBlockingQueue是线程安全、阻塞、边界可选的队列（），
 * 如果我们初始化时指定一个大小，它就是有边界的，如果不指定，它就是无边界的。
 * 说是无边界，其实是采用了默认大小为Integer.MAX_VALUE的容量 。
 * 它的内部实现是一个链表。
 * 同样是先进先出方式存储数据。
 * 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class LinkedBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
		blockingQueue.add(1);
		blockingQueue.add(2);
		blockingQueue.add(3);
		//offer方法可以设定最大时间限度，此时间前未完成的话放弃该操作，返回值为boolean值，表示是否操作成功。
		boolean result = blockingQueue.offer(4, 1, TimeUnit.SECONDS);
		System.out.println(result);
		//从队列中取出数据
		System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
		
		
	}

}
