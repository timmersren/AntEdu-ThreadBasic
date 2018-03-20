package cn.rain.design.proxy.demo2;


/**
 * description: 在demo1中我们知道了，如果我们想实现对于可移动物体（即实现了Movable接口的类）的日志或者打印时间的代理，
 * 我们就需要像LogProxyTank这样的类来实现代理。如果我们有100种需求，就要有100个这样的类，那么我们看下面这段代码。
 * 现在我把LogProxyTank作为字符串拷贝过来了，如果我们能通过某种方法，将下面这段字符当成代码来将其编译，那么不就有了一个代理类了吗。
 * 在jdk6以后，java中新增加的JavaCompiler类可以完成这个功能。除JDK外，一些第三方库也能实现该功能，其中应用最多的就是CGLib和ASM。
 * spring中的AOP就是基于CGLib来实现的，CGLib是基于ASM实现的。我们先使用JDK自带的JavaCompiler进行测试，请看CompileTest。
 * @author 任伟
 * @date 2018-03-19 16:25:50
 */
public class MyProxy {
	public static Object newProxyInstance() {
		String src =
		"package cn.rain.design.proxy.demo2;" +
		"import cn.rain.design.proxy.demo1.model.Movable;" + 
		"// 这是由CompileTest生成的java文件，并且已经进行了编译！！！" + 
		"public class CompileTimeProxyTank implements Movable {" + 
		"	private Movable moveableThing;" +
		"	public CompileTimeProxyTank(Movable moveableThing) {" +
		"		this.moveableThing = moveableThing;" +
		"	}" +
		"	@Override"+
		"	public void move() {" +
		"		System.out.println(\"logger is start!\");" +
		"		moveableThing.move();" +
		"		System.out.println(\"logger is end!\");" + 
		"	}" + 
		"}" ;

		return null;
	}
}
