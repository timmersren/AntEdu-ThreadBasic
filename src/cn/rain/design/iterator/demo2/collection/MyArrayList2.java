package cn.rain.design.iterator.demo2.collection;

import cn.rain.design.iterator.demo2.iterator.MyIterator;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class MyArrayList2 implements MyCollection2 {

	private int index = 0; 
	// 创建一个容量为10的Object数组
	Object[] arrObj = new Object[10];
	
	@Override
	public void add(Object obj) {
		if (index == arrObj.length) { 
			Object[] newArrObj = new Object[arrObj.length * 2];
			System.arraycopy(arrObj, 0, newArrObj, 0, arrObj.length);
			arrObj = newArrObj;
		}
		arrObj[index] = obj; 
		index++;
	}
	
	@Override
	public int size() {
		return index;
	}

	/**
	 * 这个方法要求返回一个Iterator迭代器，在ArrayList这个具体的集合中，
	 * 我们必须给出一个有具体实现的Iterator,我们可以选择再新建一个Class(假如叫ArrayListIterator)
	 * 实现Iterator接口，来针对ArrayList完成具体的迭代逻辑。
	 * 然后我们在这个iterator方法中，直接return new ArrayListIterator即可。
	 * 此外，更便捷的方式我们可以选择使用内部类来完成，JDK中正式使用的内部类。
	 */
	@Override
	public MyIterator iterator() {
		return new Itr(); //直接返回ArrayList迭代器的具体实现。
	}
	
	// ArrayList迭代器的具体实现
	private class Itr implements MyIterator {

		int currentCount = 0;
		
		@Override
		public boolean hasNext() {
			if (currentCount >= index) {
				return false;
			}
			else {
				return true;
			}
		}

		@Override
		public Object next() {
			Object object = arrObj[currentCount];
			currentCount ++;
			return object;
		}
		 
	 }

}
