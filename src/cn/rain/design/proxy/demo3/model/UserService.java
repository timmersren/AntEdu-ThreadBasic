package cn.rain.design.proxy.demo3.model;

/**
 * description: 模拟service，模拟测试transaction事务控制
 * @author 任伟
 * @date 2018-03-23 15:02:59
 */
public interface UserService {
	void insertUser() throws Exception;
	void deleteUser();
}
