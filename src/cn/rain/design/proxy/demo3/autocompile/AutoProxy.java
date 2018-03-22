package cn.rain.design.proxy.demo3.autocompile;

// 这是由CompileTest生成的java文件，并且已经进行了编译！！！
public class AutoProxy implements cn.rain.design.proxy.demo3.model.MyInterface{

	private cn.rain.design.proxy.demo3.model.MyInterface param;

	public AutoProxy(cn.rain.design.proxy.demo3.model.MyInterface param) {
		this.param = param;
	}

	@Override
	public void run() {
		System.out.println("logger is start!");
		param.run();
		System.out.println("logger is end!");
	}

	@Override
	public void interrupt() {
		System.out.println("logger is start!");
		param.interrupt();
		System.out.println("logger is end!");
	}

	@Override
	public void stop() {
		System.out.println("logger is start!");
		param.stop();
		System.out.println("logger is end!");
	}

	@Override
	public void myContinue() {
		System.out.println("logger is start!");
		param.myContinue();
		System.out.println("logger is end!");
	}


}