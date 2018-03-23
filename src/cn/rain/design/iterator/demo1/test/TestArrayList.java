package cn.rain.design.iterator.demo1.test;

import cn.rain.design.iterator.demo1.model.Cat;
import cn.rain.design.iterator.demo1.mycollection.MyArrayList;
import cn.rain.design.iterator.demo1.mycollection.MyCollection;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestArrayList {
	public static void main(String[] args) {
		MyCollection collection = new MyArrayList();
		for (int i = 0; i < 15; i++) {
			Cat cat = new Cat(i);
			collection.add(cat);
		}
		System.out.println(collection.size());
	}
}
