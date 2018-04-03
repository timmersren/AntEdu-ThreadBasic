package cn.rain.annotation.demo2.hand;

import java.lang.annotation.Annotation;

import cn.rain.annotation.demo2.container.MyContainer;
import cn.rain.annotation.demo2.service.UserService;

/**
 * description: 将标识了@Service或@Component注解的类加载到容器中。
 * @author 任伟
 * @date Apr 3, 2018
 */
public class LoadBeanMain {
	public static void main(String[] args) throws Exception {
		// 在spring的配置文件中，配置需要被扫描的包，于是能从该包中获取所有文件的文件名。
		// 这里我们省略这一步，直接假设我们已经获取到了文件名。
		MyContainer container = volidateAnnotation("cn.rain.annotation.demo2.service.UserService");
		UserService service = (UserService)container.getBean("0");
		service.run();
	}
	
	public static MyContainer volidateAnnotation(String className) throws Exception{
		Class<?> clazz = Class.forName(className);
		Annotation[] annotations = clazz.getAnnotations(); //获取该类上的所有注解
		MyContainer container = MyContainer.getInstance();
		
		for(int i=0; i< annotations.length; i++){
			Annotation annotation = annotations[i];
			//如果该类的头上标注了@Component或者@Service注解
			if (annotation.toString().contains("annotation.Component") 
					|| annotation.toString().contains("annotation.Service") ) {
				Class<?> clazz2 = Class.forName(className);
				Object instance = clazz2.newInstance();
				container.put(String.valueOf(i), instance);
			}
			
			// 如果类头上标注了@ClassNameMax5Word注解
			if (annotation.toString().contains("annotation.ClassNameMax5Word")) {
				Class<?> clazz3 = Class.forName(className);
				String clazzName = clazz3.getName();
				if (className.length() > 10) {
					throw new Exception("类名不能超过10个字符");
				}
			}
		}
		return container;
	}
}
