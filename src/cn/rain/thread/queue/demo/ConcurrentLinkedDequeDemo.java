package cn.rain.thread.queue.demo;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * description: 
 * ConcurrentLinkedDeque队列特点：
 * 1.非阻塞
 * 2.无界
 * 3.线程安全（适用于高并发）
 * 4.先进先出
 * 
 * 使用注意事项：队列中的元素不能为null。
 * 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class ConcurrentLinkedDequeDemo {
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
		//向队列中添加元素（不能添加null），使用offer和add无任何区别
		deque.offer("张三");
		deque.offer("李四");
		deque.offer("王五");
		
		System.out.println(deque.size());
		//poll:取出并移除该队列中的下一个元素（先进先出）
		System.out.println(deque.poll());
		System.out.println(deque.size());
		//peek：取出下一个元素，但并不从队列中移除
		System.out.println(deque.peek());
		System.out.println(deque.size());
	}
	

}
