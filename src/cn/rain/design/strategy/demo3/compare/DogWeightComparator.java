package cn.rain.design.strategy.demo3.compare;

import cn.rain.design.strategy.demo3.model.Dog;

/**
 * description: 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class DogWeightComparator implements MyComparator {

	@Override
	public int compare(Object o1, Object o2) {
		Dog dog1 = (Dog)o1;
		Dog dog2 = (Dog)o2;
		
		if (dog1.getWeight() > dog2.getWeight()) {
			return 1;
		}
		else if (dog1.getWeight() < dog2.getWeight()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
