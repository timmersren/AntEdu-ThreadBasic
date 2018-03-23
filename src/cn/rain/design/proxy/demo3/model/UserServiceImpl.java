package cn.rain.design.proxy.demo3.model;

/**
 * description:
 * @author 任伟
 * @date 2018-03-23 15:04:11
 */
public class UserServiceImpl implements UserService {

	@Override
	public void insertUser() throws Exception {
		System.out.println("向数据库中插入了一个用户");
		System.out.println("向另一个数据库插入了一条日志");
		throw new Exception("测试抛出异常会不会rollback");
	}

	@Override
	public void deleteUser() {
		System.out.println("从数据库中删除了一个用户");
	}

}
