package cn.rain.annotation.demo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description: @Retention注解生命周期的解释: 
 * 1.SOURCE:在源文件中有效（即源文件保留）。编译时会去除注解，若使用这种那么反射时获取不到该注解。
 * 2.CLASS:在class文件中有效（即class保留） 
 * 3.RUNTIME:在运行时有效（即运行时保留）
 * 
 * @author 任伟
 * @date Apr 3, 2018
 */

@Target(ElementType.TYPE) // 只能在类中进行标注。
@Retention(RetentionPolicy.RUNTIME) // 注解的生命周期，运行时依然保留该注解。
public @interface Service {

}
