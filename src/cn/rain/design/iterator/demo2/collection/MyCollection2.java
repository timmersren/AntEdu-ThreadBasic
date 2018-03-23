package cn.rain.design.iterator.demo2.collection;

import cn.rain.design.iterator.demo2.iterator.MyIterable;
import cn.rain.design.iterator.demo2.iterator.MyIterator;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyCollection2 extends MyIterable  {
	
	void add(Object object);
	
	int size();
	
	MyIterator iterator();
}
