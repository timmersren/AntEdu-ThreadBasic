package cn.rain.design.factory.demo3.test;

import java.util.Properties;

import cn.rain.design.factory.demo3.factory.BeanFactory;
import cn.rain.design.factory.demo3.factory.ClasspathXmlApplicationContext;
import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 简单模拟Spring中bean工厂的实现
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo3 {
	public static void main(String[] args) throws Exception {
		
		String filePath = "cn/rain/design/factory/demo3/applicationContext.properties";
		BeanFactory factory = new ClasspathXmlApplicationContext(filePath);
		Movable car = (Movable) factory.getBean("car");
		car.move();
		Movable train = (Movable) factory.getBean("train");
		train.move();
		Movable plane = (Movable) factory.getBean("plane");
		plane.move();
	}
}
