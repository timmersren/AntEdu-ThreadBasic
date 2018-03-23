package cn.rain.design.iterator.demo2.iterator;

/**
 * description: 我们知道，集合中最重要的功能就是遍历元素。
 * 现在我们按照JDK的思想简单实现集合中的迭代。
 * 这是一个接口，所有实现(继承)了这个接口的类(接口)必须是可迭代的。
 * 该接口只有一个抽象方法，返回一个迭代器Iterator。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyIterable {
	MyIterator iterator(); // 返回一个迭代器Iterator
}
