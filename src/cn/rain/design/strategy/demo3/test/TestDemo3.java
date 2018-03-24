package cn.rain.design.strategy.demo3.test;

import cn.rain.design.strategy.demo2.sort.ComparableDataSort;
import cn.rain.design.strategy.demo3.compare.DogHeightComparator;
import cn.rain.design.strategy.demo3.compare.DogWeightComparator;
import cn.rain.design.strategy.demo3.compare.MyComparator;
import cn.rain.design.strategy.demo3.model.Dog;

/**
 * description:
 * 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo3 {
	public static void main(String[] args) {
//		MyComparator comparator = new DogHeightComparator(); //使用身高比较器进行比较
		MyComparator comparator = new DogWeightComparator(); //使用体重比较器进行比较
		Dog[] array = {new Dog(1, 3, comparator), new Dog(7, 2, comparator), new Dog(2, 4, comparator)};
		ComparableDataSort.sort(array);
		ComparableDataSort.print(array);
		
	}
}
