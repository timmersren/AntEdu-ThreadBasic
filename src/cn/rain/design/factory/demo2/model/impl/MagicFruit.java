package cn.rain.design.factory.demo2.model.impl;

import cn.rain.design.factory.demo2.model.Food;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class MagicFruit implements Food {

	@Override
	public void printName() {
		System.out.println("神奇的果实");
	}

}
