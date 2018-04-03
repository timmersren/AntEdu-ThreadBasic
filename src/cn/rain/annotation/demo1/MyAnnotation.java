package cn.rain.annotation.demo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * description: 自定义注解入门demo,自定义注解使用@interface进行创建。
 * 这里需要说明的是，注解的作用仅仅是用来标注，它是用来描述诸如类、方法、属性等的
 * 描述信息（即元数据），它内部没有任何业务逻辑。
 * 那么问题来了，注解如何实现校验判断的？其实这和定义的注解没有什么关系，
 * 注解仅仅是将需要进行校验判断的地方进行标注，真正实现逻辑判断的方式是使用
 * 反射来获取标注了注解的数据进行判断，具体的参看demo2中简单模拟spring @Component的实现。
 * @author 任伟
 * @date Apr 3, 2018
 */

@Target(ElementType.TYPE)
public @interface MyAnnotation {
	String value();
	int length();
}
