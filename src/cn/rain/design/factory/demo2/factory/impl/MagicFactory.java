package cn.rain.design.factory.demo2.factory.impl;

import cn.rain.design.factory.demo2.factory.AbstractFactory;
import cn.rain.design.factory.demo2.model.Food;
import cn.rain.design.factory.demo2.model.Vehicle;
import cn.rain.design.factory.demo2.model.Weapon;
import cn.rain.design.factory.demo2.model.impl.MagicBroom;
import cn.rain.design.factory.demo2.model.impl.MagicFruit;
import cn.rain.design.factory.demo2.model.impl.MagicStick;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class MagicFactory extends AbstractFactory {

	@Override
	public Vehicle createVehicle() {
		return new MagicBroom();
	}

	@Override
	public Food createFood() {
		return new MagicFruit();
	}

	@Override
	public Weapon createWeapon() {
		return new MagicStick();
	}

}
