package cn.rain.design.proxy.demo1.extendsproxy;

import cn.rain.design.proxy.demo1.model.Tank;

/**
 * description: 现在的需求是想要记录一下Tank类中的move方法执行前后的时间，
 * 单单思考本需求，我们可以通过继承的方式在重写Tank的move方法加上时间的记录。
 * @author 任伟
 * @date 2018年3月19日
 */
public class TimeTank extends Tank {
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("move time is " + (end - start) + "ms");
	}
}
