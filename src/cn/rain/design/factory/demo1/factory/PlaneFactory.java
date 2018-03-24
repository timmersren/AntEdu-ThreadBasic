package cn.rain.design.factory.demo1.factory;

import cn.rain.design.factory.demo1.model.Plane;
import cn.rain.design.proxy.demo1.model.Movable;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class PlaneFactory extends AbstractMovableFactory {

	@Override
	public Movable create() {
		return new Plane();
	}

}
