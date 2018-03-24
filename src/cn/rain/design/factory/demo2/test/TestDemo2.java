package cn.rain.design.factory.demo2.test;

import cn.rain.design.factory.demo2.factory.AbstractFactory;
import cn.rain.design.factory.demo2.factory.impl.CommonFactory;
import cn.rain.design.factory.demo2.factory.impl.MagicFactory;
import cn.rain.design.factory.demo2.model.Food;
import cn.rain.design.factory.demo2.model.Vehicle;
import cn.rain.design.factory.demo2.model.Weapon;

/**
 * description: demo2中的抽象工厂和demo1中的简单工厂的区别，首先来说其实我们如果非要使用demo1
 * 的简单工厂来实现demo2的功能也是可以的，怎么做呢？首先我们还要新建AbstactFoodFactory、
 * AbstractWeaponFactory，然后还要建具体的实现工厂AppleFactory、MagicFruitFactory、AKFactory、
 * MagicStickFactory。然后使用的时候需要对每个实现工厂进行实例化。这样做不仅代码量增加了，让程序变得
 * 非常臃肿，并且我们可以数一下，加上demo1中的3个工厂，这里一共有9个工厂！而demo2中我们仅仅有3个工厂，
 * 这就又造成了一个问题，工厂泛滥。
 * 
 * 简单工厂和抽象工厂的区别从宏观上来讲，简单工厂在产品的维度是易于扩展的，比如对于AbstractMovableFactory来说，
 * 可以很容易的扩展出CarFactory、BikeFactory、TankFactory等等，但是随之而来的问题确实工厂的泛滥。
 * 而抽象工厂解决了工厂泛滥的问题，但是从产品系列的维度的角度来说，为系列中增删产品是难于实现的。
 * 比如说我们的demo2.AbstractFactory，如果除了Vehicle、Food、Weapon外，现在还想添加一个新的产品进去，
 * AbstractFactory及其实现类都要对源码进行改动。所以说简单工厂和抽象工厂都有各自的好处和缺点。
 * 
 * 在demo2中我们使用抽象工厂的好处，如果我们对这一系列事物不满意，那么我们只需按照自己的逻辑对这些
 * 事物（Vehicle、Food、Weapon）进行实现，然后再创建一个生产我们自己实现的事物的工厂，便可以
 * 很容易的替换掉之前的实现，极大的降低了耦合度。
 * @author 任伟
 * @date Mar 24, 2018
 */
public class TestDemo2 {
	public static void main(String[] args) {
		
		//现在需要一系列普通的物品，就创建普通工厂
//		AbstractFactory factory = new CommonFactory();
		//如果现在需要一系列魔法物品，那么只需更改抽象工厂实现的实例即可,其他都无需改变
		AbstractFactory factory = new MagicFactory();
		
		Vehicle vehicle = factory.createVehicle();
		vehicle.move();
		Food food = factory.createFood();
		food.printName();
		Weapon weapon = factory.createWeapon();
		weapon.shoot();
	}
}
