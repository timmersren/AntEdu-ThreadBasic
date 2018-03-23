package cn.rain.design.iterator.demo2.test;

import cn.rain.design.iterator.demo1.model.Cat;
import cn.rain.design.iterator.demo2.collection.MyArrayList2;
import cn.rain.design.iterator.demo2.iterator.MyIterator;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestArrayList {
	public static void main(String[] args) {
		MyArrayList2 arrayList = new MyArrayList2();
		for (int i = 0; i < 15; i++) {
			Cat cat = new Cat(i);
			arrayList.add(cat);
		}
		
		MyIterator iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
