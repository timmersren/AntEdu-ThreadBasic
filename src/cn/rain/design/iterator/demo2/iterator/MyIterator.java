package cn.rain.design.iterator.demo2.iterator;

/**
 * description: 这是迭代器的接口，该接口有两个方法。
 * 也即迭代器的通用方法，由于不同的集合迭代方式不同。
 * 但是迭代思想是一样的，有没有下一个（hasNext），取出下一个（next）
 * 因此接口定义了这两个抽象方法，具体实现我们不关心。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyIterator {
	
	boolean hasNext(); // 是否有下一个元素
	
	Object next(); // 返回下一个元素
}
