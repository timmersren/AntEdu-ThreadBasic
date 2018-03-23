package cn.rain.design.iterator.demo1.mycollection;

/**
 * description: 由于ArrayList和LinkedList仅仅是数据结构不同，
 * 而里面的方法几乎完全相同，因此要求用户在选择它们的时候是可以随意切换的，
 * 但是如果它们两个定义的方法名不一样，那么切换时会修改更多的代码，
 * 因此我们定义这样一个集合的接口，让它们两个都继承这个接口。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyCollection {
	void add(Object object);
	int size();
}
