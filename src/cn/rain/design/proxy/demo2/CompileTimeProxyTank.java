package cn.rain.design.proxy.demo2;
import cn.rain.design.proxy.demo1.model.Movable;

// 这是由CompileTest生成的java文件，并且已经进行了编译！！！
public class CompileTimeProxyTank implements Movable {

	private Movable moveableThing;

	public CompileTimeProxyTank(Movable moveableThing) {
		this.moveableThing = moveableThing;
	}

	@Override
	public void move() {
		System.out.println("logger is start!");
		moveableThing.move();
		System.out.println("logger is end!");
	}
}