package cn.rain.design.strategy.demo1.test;

import cn.rain.design.strategy.demo1.model.Cat;
import cn.rain.design.strategy.demo1.sort.DataSortor;

/**
 * description: 我们先来做这样一个小程序。
 * 将给出的int数组中的数字先进行排序，然后打印出来排序后的结果。
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo1 {
	public static void main(String[] args) {
//		int array[] = {9, 5, 3, 7, 1};
		/**
		 *  现在想对猫进行排序，那么DataSort中就必须给出Cat数组的重载方法。
		 *  那下次想对狗进行排序，就还要加重载方法，这样加下去是无穷无尽的。
		 *  因此这种设计方法肯定不可行，请看demo2。
		 */
		Cat array[] = {new Cat(5, 5), new Cat(1, 1), new Cat(3, 3)};
		DataSortor.sort(array);
		DataSortor.print(array);
	}
}
