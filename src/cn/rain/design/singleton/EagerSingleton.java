package cn.rain.design.singleton;

/**
 * description: 饿汉式单例设计模式
 * @author 任伟
 * @date Mar 17, 2018
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton(); //程序启动时本类实例就会被创建       
    private EagerSingleton(){
       //private修饰构造器，保证本类不能被创建实例
    }  
    public static EagerSingleton getInstance(){ //通过静态函数使程序中任何地方都能获取到本类的实例
        return instance;
    } 
}
