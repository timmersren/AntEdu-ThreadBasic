package cn.rain.design.factory.demo1.test;

import cn.rain.design.factory.demo1.factory.AbstractMovableFactory;
import cn.rain.design.factory.demo1.factory.CarFactory;
import cn.rain.design.factory.demo1.factory.PlaneFactory;
import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: demo1讲解的是简单工厂的实现，这里做测试。
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo1 {
	public static void main(String[] args) {
		// 现在想要生产汽车，我们就创建汽车工厂的实例
//		AbstractMovableFactory factory = new CarFactory();
		// 如果我们想生产飞机，将抽象工厂的实现改成飞机就好了
		AbstractMovableFactory factory = new PlaneFactory();
		Movable movable = factory.create();
		movable.move();
	}
}
