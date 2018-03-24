package cn.rain.design.factory.demo2.model.impl;

import cn.rain.design.factory.demo2.model.Vehicle;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class Car implements Vehicle {

	@Override
	public void move() {
		System.out.println("汽车");
	}

}
