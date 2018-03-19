package cn.rain.design.proxy.demo1.staticproxy;

import cn.rain.design.proxy.demo1.model.Tank;

/**
 * description: 我们已经知道了，不管是打印时间的TimeProxyTank还是记录日志的LogProxyTank，
 * 他们都能聚合进一个实现了movable接口的类，由于他们两个自己也实现了movable，因此它们两个之间也可以相互聚合。
 * 那么此时，由于具体move细节是由Tank来实现的，如果我们现在的需求是先记录日志再记录时间，那么我们只需要先将Tank类
 * 聚合进LogProxyTank，让LogProxyTank代理Tank的move方法并且为其加上日志记录的功能。然后我们再讲LogProxyTank
 * 聚合进TimeProxyTank，由于被聚合进来的LogProxyTank的move方法已经在最初的move方法上加上了日志记录的功能，
 * 所以我们在LogProxyTank的move方法的基础上再加上日志打印的功能。
 * 如果我们想先打印时间再记录日志，我们只需将他们俩的注入顺序颠倒一下就可以了，非常的简便，比继承的方式扩展性高。
 * @author 任伟
 * @date 2018-03-19 15:17:43
 */
public class StaticProxyMain {
	public static void main(String[] args) {
		Tank basicTank = new Tank();
		
		//先记录日志再记录时间
//		LogProxyTank logProxyTank = new LogProxyTank(basicTank);
//		TimeProxyTank timeProxyTank = new TimeProxyTank(logProxyTank);
//		timeProxyTank.move();
		
		//先记录时间再记录日志
		TimeProxyTank timeProxyTank = new TimeProxyTank(basicTank);
		LogProxyTank logProxyTank = new LogProxyTank(timeProxyTank);
		logProxyTank.move();
	}
}
