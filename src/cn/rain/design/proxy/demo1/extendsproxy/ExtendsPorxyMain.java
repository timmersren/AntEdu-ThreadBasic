package cn.rain.design.proxy.demo1.extendsproxy;


/**
 * description: 此时我们运行LoggerTank的方法便会先打印日志,然后记录时间。
 * 但是现在我们思考一下，如果我现在需求变了，要先打印时间，再记录日志应该怎么办。
 * 解决办法是从新写一个LoggerTank先继承Tank，然后TimeTank再继承这个LoggerTank。
 * 好的，问题解决了，但这仅仅是两个需求，要求更改个顺序就改动这么大，如果我们100种东西要记录呢，
 * 那么会衍生出无数种的组合。显然，通过继承来的方法来完成需求是绝对不可行，扩展性极差。
 * @author 任伟
 * @date 2018-03-19 14:39:50
 */
public class ExtendsPorxyMain {
	public static void main(String[] args) {
		LoggerTank loggerTank = new LoggerTank();
		loggerTank.move();
	}
}
