package cn.rain.design.proxy.demo1.extendsproxy;

/**
 * description: 此时，我们又增加了一个需求，那就是除了打印移动的时间，我们还要在最外层加上一层日志。
 * 那我们此时需要继承打印时间的TimeProxyByExtendsTank
 * @author 任伟
 * @date 2018-03-19 14:41:15
 */
public class LoggerTank extends TimeTank{
	@Override
	public void move() {
		System.out.println("logger start!");
		super.move();
		System.out.println("logger end!!!");
	}
}
