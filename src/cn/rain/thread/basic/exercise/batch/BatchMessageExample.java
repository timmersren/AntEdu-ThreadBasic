package cn.rain.thread.basic.exercise.batch;

import java.util.ArrayList;
import java.util.List;

/**  
* description: 模拟使用多线程给1000个用户批量发送信息  
* @author 任伟  
* @date Mar 8, 2018
*/
public class BatchMessageExample {
	public static void main(String[] args) {
		//1.初始化数据
		List<User> totalLstUser = initUsers(1000);
		//2.定义每个线程要发送的信息数
		int threadMessageCount = 200;
		//3.为每个线程分配其要跑的数据
		List<List<User>> batchLstUser = ListUtils.splitList(totalLstUser, threadMessageCount);
		for (int i = 0; i < batchLstUser.size(); i++) {
			//获取第i组用户
			List<User> lstUser = batchLstUser.get(i);
			//创建一条线程为该组用户发送消息
			SendMessageThread messageThread = new SendMessageThread(lstUser);
			Thread thread = new Thread(messageThread, "线程" + (i+1));
			//4.开启线程给用户发送消息
			thread.start();
		}
	}
	
	private static List<User> initUsers(int userNum){
		List<User> lstUser = new ArrayList<>();
		for (int i = 0; i < userNum; i++) {
			lstUser.add(new User("userId:" + i, "username" + i));
		}
		return lstUser;
	}
	
}
