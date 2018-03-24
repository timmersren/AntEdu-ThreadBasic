package cn.rain.design.factory.demo2.model.impl;

import cn.rain.design.factory.demo2.model.Weapon;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class Ak47 implements Weapon {

	@Override
	public void shoot() {
		System.out.println("ak47, 突突突扫射...");
	}

}
