package cn.rain.design.factory.demo3.model;

import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TrainDemo3 implements Movable {

	@Override
	public void move() {
		System.out.println("火车呜呜呜...");
	}

}
