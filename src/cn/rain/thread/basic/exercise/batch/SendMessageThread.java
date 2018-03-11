package cn.rain.thread.basic.exercise.batch;

import java.util.List;

/**  
* description:   
* @author 任伟  
* @date Mar 8, 2018
*/
public class SendMessageThread implements Runnable{

	private List<User> lstUser;
	
	public SendMessageThread(List<User> lstUser) {
		super();
		this.lstUser = lstUser;
	}

	@Override
	public void run() {
		for (User user : lstUser) {
			System.out.println("正在给" + user.getUsername() + "发送信息..." + Thread.currentThread().getName());
		}
		System.out.println();
	}
	
}
