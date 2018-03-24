package cn.rain.design.strategy.demo3.model;

import cn.rain.design.strategy.demo2.compare.MyComparable;
import cn.rain.design.strategy.demo3.compare.MyComparator;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class Dog implements MyComparable {

	private int height;
	private int weight;
	private MyComparator comparator;
	
	public Dog(int height, int weight, MyComparator comparator) {
		super();
		this.height = height;
		this.weight = weight;
		this.comparator = comparator;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [height=" + height + ", weight=" + weight + "]";
	}



	@Override
	public int compareTo(Object obj) {
		return comparator.compare(this, obj);
	}

}
