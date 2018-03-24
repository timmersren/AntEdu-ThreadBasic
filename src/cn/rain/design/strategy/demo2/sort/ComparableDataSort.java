package cn.rain.design.strategy.demo2.sort;

import cn.rain.design.strategy.demo2.compare.MyComparable;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class ComparableDataSort {
	public static void sort(Object[] array) {
		for (int i = array.length; i >0; i--) {
			for(int j=0; j<i-1; j++){
				MyComparable obj1 = (MyComparable)array[j];
				MyComparable obj2 = (MyComparable)array[j+1];
				if (obj1.compareTo(obj2) == 1) {
					swap(array, j, j+1);
				}
			}
		}
	}

	private static void swap(Object[] array, int j, int i) {
		Object temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	public static void print(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
