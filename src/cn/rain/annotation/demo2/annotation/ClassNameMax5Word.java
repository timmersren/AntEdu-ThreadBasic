package cn.rain.annotation.demo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description: 自定义注解，使用该注解的类的类名最大字符数只能为10。
 * @author 任伟
 * @date Apr 3, 2018
 */
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassNameMax5Word {

}
