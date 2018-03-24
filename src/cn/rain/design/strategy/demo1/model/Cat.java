package cn.rain.design.strategy.demo1.model;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class Cat {
	
	private int height; //猫的身高
	private int weight; //猫的体重
	
	public Cat(int height, int weight) {
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
		return "Cat [height=" + height + ", weight=" + weight + "]";
	}
}
