package cn.rain.annotation.demo2.container;

import java.util.HashMap;

/**
 * description: 简单模拟Ioc容器。
 * @author 任伟
 * @date Apr 3, 2018
 */
public class MyContainer extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;
	
	
	private static MyContainer container = new MyContainer();
	
	private MyContainer(){
		
	}
	
	public static MyContainer getInstance(){
		return container;
	}
	
	public Object getBean(String key) throws Exception{
		Object object = get(key);
		if (object != null) {
			return object;
		}else {
			throw new Exception("Failed to create Bean!");
		}
	}
}
