package cn.rain.design.factory.demo1.factory;

import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 这是一个抽象的工厂原型，一切生产可移动物体的实体工厂都应从此工厂继承。
 * 因为我不知道工厂具体是生产什么可移动物体的工厂，可能是生产Car的，可能是Plane的。
 * 但是我能知道工厂一定有一个方法是能生产出一个可移动的物体（即实现了Movable接口的类）
 * @author 任伟
 * @date Mar 24, 2018
 */
public abstract class AbstractMovableFactory {
	public abstract Movable create();
}
