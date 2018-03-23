package cn.rain.design.iterator.demo1.mycollection;

/**
 * description: 简单模拟ArrayList
 * @author 任伟
 * @date Mar 23, 2018
 */
public class MyArrayList implements MyCollection {
	
	// 初始化判断元素脚标的变量index
	private int index = 0; 
	// 创建一个容量为10的Object数组
	Object[] arrObj = new Object[10];
	
	@Override
	public void add(Object obj) {
		// 如果此时脚标为数组的长度，说明已经装满了，要进行扩容
		if (index == arrObj.length) { 
			Object[] newArrObj = new Object[arrObj.length * 2];
			//将之前的obj数组中的元素copy到新数组中
			//参数分别为：老的数组，从第几个元素开始copy，新的目标数组，从目标数组第几个元素开始，一共copy几个元素
			System.arraycopy(arrObj, 0, newArrObj, 0, arrObj.length);
			// 将之前数组的引用指向新的数组
			arrObj = newArrObj;
		}
		arrObj[index] = obj; //将要添加的obj添加到数组中。
		index++;
	}
	
	@Override
	public int size() {
		return index;
	}
}
