package cn.rain.design.iterator.demo1.model;

/**
 * description: 仅为了向集合中添加元素之用
 * @author 任伟
 * @date Mar 23, 2018
 */
public class Cat {
	private int id;
	
	public Cat() {
		super();
	}

	public Cat(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + "]";
	}
}
