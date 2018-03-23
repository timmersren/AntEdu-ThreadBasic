package cn.rain.design.proxy.demo3.autocompile;

import java.lang.reflect.Method;
import cn.rain.design.proxy.demo3.handler.MyInvocationHandler;

// 这是由Step2生成的java文件，并且已经进行了编译！！！
public class $Proxy1 implements cn.rain.design.proxy.demo3.model.UserService{

	private MyInvocationHandler handler;

	public $Proxy1(MyInvocationHandler handler) {
		this.handler = handler;
	}

	@Override
	public void deleteUser() {
		try{
			Method m = cn.rain.design.proxy.demo3.model.UserService.class.getMethod("deleteUser");
			handler.invoke(this, m);
		}catch(NoSuchMethodException | SecurityException e){
			e.printStackTrace();
		}
	}

	@Override
	public void insertUser() {
		try{
			Method m = cn.rain.design.proxy.demo3.model.UserService.class.getMethod("insertUser");
			handler.invoke(this, m);
		}catch(NoSuchMethodException | SecurityException e){
			e.printStackTrace();
		}
	}


}