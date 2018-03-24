package cn.rain.design.strategy.demo2.compare;

/**
 * description: 正如demo1中所说，我们不能无限制的去加排序的重载方法。
 * 因此我们这里定义一个Comparable接口，使得只要实现了此接口的类都具备可比较性。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface MyComparable {
	/**
	 * @param int 1:调用compareTo方法的对象比参数的对象大; 
	 * 			 -1:调用compareTo方法的对象比参数的对象小;
	 * 			  0:调用compareTo方法的对象和参数的对象一样大。
	 */
	int compareTo(Object obj);
}
