package cn.rain.design.strategy.demo2.test;

import cn.rain.design.strategy.demo2.model.ComparableCat;
import cn.rain.design.strategy.demo2.sort.ComparableDataSort;

/**
 * description:
 * 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo2 {
	public static void main(String[] args) {
		ComparableCat[] cats = {new ComparableCat(3, 3), new ComparableCat(5, 5), new ComparableCat(1, 1)};
		ComparableDataSort.sort(cats);
		ComparableDataSort.print(cats);
	}
}
