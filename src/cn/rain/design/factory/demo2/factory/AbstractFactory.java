package cn.rain.design.factory.demo2.factory;

import cn.rain.design.factory.demo2.model.Food;
import cn.rain.design.factory.demo2.model.Vehicle;
import cn.rain.design.factory.demo2.model.Weapon;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public abstract class AbstractFactory {
	
	public abstract Vehicle createVehicle();
	
	public abstract Food createFood();
	
	public abstract Weapon createWeapon();
}
