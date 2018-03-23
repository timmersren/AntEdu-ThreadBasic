package cn.rain.design.proxy.demo3.test;

import cn.rain.design.proxy.demo3.Step2;
import cn.rain.design.proxy.demo3.handler.MyInvocationHandler;
import cn.rain.design.proxy.demo3.handler.TransactionHandler;
import cn.rain.design.proxy.demo3.model.UserService;
import cn.rain.design.proxy.demo3.model.UserServiceImpl;

/**
 * description: 如果出现运行结果异常，那极有可能是因为编译缓存引起的。
 * 我们打开navigator视图，将里面生成的.class文件删除从新多运行即便就可以了。
 * @author 任伟
 * @date 2018-03-23 15:00:34
 */
public class TestTransaction {
	public static void main(String[] args) throws Exception {
		UserService service = new UserServiceImpl(); 
		MyInvocationHandler handler = new TransactionHandler(service);
		UserService userService = (UserService) Step2.newProxyInstance(UserService.class, handler);
		userService.deleteUser();
		userService.insertUser();
	}
}
