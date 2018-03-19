package cn.rain.design.proxy.demo1.staticproxy;

import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 接着，我们通过聚合的方式来完成刚才的需求以便增加灵活度。
 * @author 任伟
 * @date 2018-03-19 14:55:44
 */
public class TimeProxyTank implements Movable{ 
	
	private Movable moveableThing;
	//我们在这里聚合一个可移动的东西，不管它是汽车或者坦克还是火车，只要其可移动（即实现了Moveable接口）便可以聚合进来。
	public TimeProxyTank(Movable moveableThing) {
		this.moveableThing = moveableThing;
	}

	/*
	 * 在我们实现本类的move方法的时候，重点不在于我们去如何实现move的细节，这不是我们要做的，
	 * 我们在这里是直接使用聚合进来的那个可移动的东西的move方法的实现。
	 * 而我们要做的是在它的move方法前后加上时间的记录,这就是所谓代理的意思。
	 * */
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		moveableThing.move();
		long end = System.currentTimeMillis();
		System.out.println("move time is: " + (end - start) + "ms");
	}
}
