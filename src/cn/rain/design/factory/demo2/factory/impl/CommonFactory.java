package cn.rain.design.factory.demo2.factory.impl;

import cn.rain.design.factory.demo2.factory.AbstractFactory;
import cn.rain.design.factory.demo2.model.Food;
import cn.rain.design.factory.demo2.model.Vehicle;
import cn.rain.design.factory.demo2.model.Weapon;
import cn.rain.design.factory.demo2.model.impl.Ak47;
import cn.rain.design.factory.demo2.model.impl.Apple;
import cn.rain.design.factory.demo2.model.impl.Car;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class CommonFactory extends AbstractFactory {

	@Override
	public Vehicle createVehicle() {
		return new Car();
	}

	@Override
	public Food createFood() {
		return new Apple();
	}

	@Override
	public Weapon createWeapon() {
		return new Ak47();
	}

}
