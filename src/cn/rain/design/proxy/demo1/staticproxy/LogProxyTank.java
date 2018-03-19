package cn.rain.design.proxy.demo1.staticproxy;

import cn.rain.design.proxy.demo1.model.Movable;
/**
 * description:
 * @author 任伟
 * @date 2018-03-19 15:10:34
 */
public class LogProxyTank implements Movable {
	private Movable moveableThing;
	
	public LogProxyTank(Movable moveableThing) {
		this.moveableThing = moveableThing;
	}
	
	@Override
	public void move() {
		System.out.println("logger is start!");
		moveableThing.move();
		System.out.println("logger is end!");
	}
}
