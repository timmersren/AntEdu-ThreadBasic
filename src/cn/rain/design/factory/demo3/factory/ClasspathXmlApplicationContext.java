package cn.rain.design.factory.demo3.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.rain.design.factory.demo3.test.TestDemo3;

/**
 * description: 模拟spring中读取配置文件并且将配置文件中的bean加载到容器中的过程。
 * 简单起见，这里使用properties代替spring中的配置文件（区别仅在于解析配置文件，重要的在于思想）。
 * 
 * 在这个简单实现中，一定要强调一点，为什么说spring是个容器，因为当spring加载配置文件之后，
 * 会通过反射为每一个bean创建实例，然后将这些bean的id和其对应的实例都装进一个（Map）集合中进行统一管理。
 * 这就是spring中容器的思想。
 * 
 * @author 任伟
 * @date Mar 24, 2018
 */
public class ClasspathXmlApplicationContext implements BeanFactory {
	
	private String path = null;
	
	// 创建管理bean的容器。
	private Map<String, Object> container = new HashMap<>();
	
	//创建本类实例使，必须传入配置文件的路径。
	public ClasspathXmlApplicationContext(String path) throws Exception {
		this.path = path;
		// 获取到文件路径后，加载配置文件并遍历，然后将所有的k、v值装进container容器中
		loadToContainer();
	}
	
	private void loadToContainer() throws Exception{
		Properties prop = new Properties();
		prop.load(TestDemo3.class.getClassLoader()
				.getResourceAsStream(path));
		// 遍历配置文件中的所有key
		Set<Object> keySet = prop.keySet();
		Iterator<Object> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = prop.getProperty(key);
			// 利用反射将获取到的value（即类的全路径）创建实例
			Object instance = Class.forName(value).newInstance();
			// 将key和通过value获取到的实例instance放入容器container中。
			container.put(key, instance); 
		}
	}
	
	
	@Override
	public Object getBean(String id) {
		return container.get(id);
	}

}
