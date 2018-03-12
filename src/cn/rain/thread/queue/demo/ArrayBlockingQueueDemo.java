package cn.rain.thread.queue.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description: ArrayBlockingQueue是一个有界、阻塞、线程安全的队列（先进先出），
 * 其内部实现是一个数组。有界就意味着我们必须在其初始化的时候指定它的容量大小，容量大小一旦指定就不可改变。
 * 
 * 注意事项：ArrayBlockingQueue由于是阻塞且有界的队列，因此在满足阻塞条件时线程除了阻塞外，
 * 还有其他的处理方式，共四种方式，分别是：
 * 抛出异常、返回特殊值、阻塞、设置最大阻塞时间（若在时间限度前未完成插入或读取，则放弃操作）	
 * 详细可看该文章：http://blog.csdn.net/wei_ya_wen/article/details/19344939
 * 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class ArrayBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		blockingQueue.add("1");
		blockingQueue.add("2");
		blockingQueue.add("3");
//		blockingQueue.remove(); //移除元素
		//offer方法可以设定最大时间限度，此时间前未完成的话放弃该操作，返回值为boolean值，表示是否操作成功。
		boolean result = blockingQueue.offer("4", 1, TimeUnit.SECONDS);
		System.out.println(result);
	}
}
