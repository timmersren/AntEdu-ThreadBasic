package cn.rain.design.factory.demo2.model.impl;

import cn.rain.design.factory.demo2.model.Weapon;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class MagicStick implements Weapon {

	@Override
	public void shoot() {
		System.out.println("魔法棒，喷射着火焰...");
	}

}
