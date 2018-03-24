package cn.rain.design.strategy.demo1.sort;

import cn.rain.design.strategy.demo1.model.Cat;

/**
 * description: 排序口诀--冒择路（谐音入：插入）兮（希尔）快归堆。
 * 冒泡、选择、插入、希尔、快速、归并、堆排序。
 * @author 任伟
 * @date Mar 24, 2018
 */
public class DataSortor {

	public static void sort(int[] array) {
		for (int i = array.length; i >0; i--) {
			for(int j=0; j<i-1; j++){
				if (array[j] > array[j+1]) {
					swap(array, j, j+1);
				}
			}
		}
		
	}

	private static void swap(int[] array, int j, int i) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void sort(Cat[] array) {
		for (int i = array.length; i >0; i--) {
			for(int j=0; j<i-1; j++){
				if (array[j].getHeight() > array[j+1].getHeight()) {
					swap(array, j, j+1);
				}
			}
		}
	}

	private static void swap(Cat[] array, int j, int i) {
		Cat temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void print(Cat[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
