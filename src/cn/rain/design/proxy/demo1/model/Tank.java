package cn.rain.design.proxy.demo1.model;

import java.util.Random;

public class Tank implements Movable{

	@Override
	public void move() {
		System.out.println("Tank moving....");
		// 通过随机数模拟tank移动的时间
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
