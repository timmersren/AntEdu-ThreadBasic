package cn.rain.design.factory.demo3.factory;

/**
 * description: 简单模拟Spring中beanFactory。
 * @author 任伟
 * @date Mar 24, 2018
 */
public interface BeanFactory {
	Object getBean(String id);
}
