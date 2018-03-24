package cn.rain.design.strategy.demo2.model;

import cn.rain.design.strategy.demo2.compare.MyComparable;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class ComparableCat implements MyComparable {
	
	private int height;
	private int weight;
	
	public ComparableCat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
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
		return "ComparableCat [height=" + height + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof ComparableCat) {
			ComparableCat cat = (ComparableCat) obj;
			if (this.getHeight() > cat.getHeight()) {
				return 1;
			}
			else if (this.getHeight() < cat.getHeight()) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			throw new RuntimeException(obj.getClass().getName() + "不能与ComparableCat进行比较");
		}
	}
}
