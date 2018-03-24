package cn.rain.design.factory.demo1.factory;

import cn.rain.design.factory.demo1.model.Car;
import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 这是一个能生产出具体物体的工厂，它继承于抽象工厂。
 * 由于这是一个CarFactory，因此它一定是生产Car的Factory。
 * @author 任伟
 * @date Mar 24, 2018
 */
public class CarFactory extends AbstractMovableFactory {

	@Override
	public Movable create() {
		return new Car();
	}

}
