package cn.rain.design.iterator.demo1.test;

import cn.rain.design.iterator.demo1.model.Cat;
import cn.rain.design.iterator.demo1.mycollection.MyCollection;
import cn.rain.design.iterator.demo1.mycollection.MyLinkedList;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestLinkedList {
	public static void main(String[] args) {
		MyCollection collection = new MyLinkedList();
		for (int i = 0; i < 35; i++) {
			Cat cat = new Cat(i);
			collection.add(cat);
		}
		System.out.println(collection.size());
	}
}
