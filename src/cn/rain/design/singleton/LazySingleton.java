package cn.rain.design.singleton;

/**
 * description: 懒汉式单例设计模式
 * 
 * @author 任伟
 * @date Mar 17, 2018
 */
public class LazySingleton {

	private volatile static LazySingleton instance = null; //volatile禁止JVM重排序

	private LazySingleton() {

	}

	public static LazySingleton getInstance() {
		if (instance == null) { //判断实例是否存在，已存在的话便可跳过synchronized直接返回该实例。
			synchronized (LazySingleton.class) {
				if (instance == null) { //线程未创建的时候，依然有可能多条线程同时进入外层的if。
					instance = new LazySingleton(); 
				}
			}
		}
		return instance; 
	}
}
