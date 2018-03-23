package cn.rain.design.proxy.demo3;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import cn.rain.design.proxy.demo3.model.MyInterface;
import cn.rain.design.proxy.demo3.model.MyModel;


/**
 * description: 在demo2中，我们已经通过ClassLoader将一段字符串编译成了可用的代码。
 * 基于此，我们便可以产生一个动态的代理了，但是现在这个代理的扩展性还是很差，因为：
 * 1.这段字符串生成的代码目前只能给Movable接口实现代理。
 * 2.只能给move方法进行代理。
 * 3.代理后的处理方式写死了，目前只能给被代理的对象加上日志。
 * 基于以上三个问题，我们会一步步的进行解决，从而得到一个扩展性极高的动态代理。
 * 本类先来解决前两个问题，让动态代理可以代理任何接口并且代理该接口中的所有方法。
 * @author 任伟
 * @date 2018-03-22 13:51:38
 */
public class Step1 {
	public static Object newProxyInstance(Class intface) throws Exception{
		String rt = "\r\n";
		
		String methodStr = "";
		//获取传入接口的方法
		Method[] methods = intface.getMethods();
		//遍历每个方法时都生成代理格式的代码的字符串
		for (Method method : methods) {
			methodStr += "	@Override" + rt +
						 "	public void " +method.getName()+ "() {" + rt + 
						 "		System.out.println(\"logger is start!\");" + rt + 
						 "		param." +method.getName()+ "();" + rt + 
						 "		System.out.println(\"logger is end!\");" +  rt + 
						 "	}" + rt + rt ;
		}
		
		String src =
				"package cn.rain.design.proxy.demo3.autocompile;" + rt + rt +
				"// 这是由Step1生成的java文件，并且已经进行了编译！！！" + rt +
				//这里如果直接使用intface那么会调用它的toString方法，从而写出的文件中会多一个interface关键字。
				"public class AutoProxy implements "+ intface.getName() +"{" + rt + rt + 
				"	private " +intface.getName()+ " param;" + rt + rt +
				"	public AutoProxy(" + intface.getName() + " param) {" + rt + 
				"		this.param = param;" + rt +
				"	}" + rt + rt +
				methodStr + rt + 
				"}" ;
		
		// 从系统中获取项目所在路径
		String projectPath = System.getProperty("user.dir");
		// 通过项目路径拼成一个路径，该路径与本类路径相同
		String filePath = projectPath + "/src/cn/rain/design/proxy/demo3/autocompile/AutoProxy.java";
		
		// 使用IO将src写入文件
		File file = new File(filePath);
		FileWriter writer = new FileWriter(file);
		writer.write(src);
		writer.flush();
		writer.close();
		
		// 获取JDK中的JavaCompiler
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		/*
		 * description: 编译文件必须要通过StandardJavaFileManager，因此我们先通过javaCompiler获取它。
		 * 第一个参数diagnosticListener是传入一个编译过程用于非致命错误诊断的监听器，传入null则使用默认监听器。
		 * 后两个参数是用于国际化的，传null意味着使用我们系统默认的。
		 */
		StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
		
		// 编译前目标文件将会被封装成文件对象，我们通过fileManager获取到目标文件的对象的迭代器。
		Iterable<? extends JavaFileObject> targerFiles = fileManager.getJavaFileObjects(filePath);
		// 获取编译任务，准备编译
		CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, targerFiles);
		//执行编译
		task.call();
		//关闭fileManager
		fileManager.close();
		
		// 由于ClassLoader要求class文件必须在classpath路径下存在，由于classpath是可以删掉的（随时可以生产）
		// 因此这里我们使用URLClassLoader，可以任意指定路径
		URL[] urlArr = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader urlClassLoader = new URLClassLoader(urlArr);
		Class<?> clazz = null;
		try {
			// 将该路径的class文件load到内存
			clazz = urlClassLoader.loadClass("cn.rain.design.proxy.demo3.autocompile.AutoProxy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			urlClassLoader.close();
		}
		
		// 通过反射获取构造器，这里我们省略获取构造器的步骤，直接传入写死的构造器
		Constructor<?> constructor = clazz.getConstructor(MyInterface.class);
		// 由于在这里我们不知道具体传入的接口是什么类型，因此我们只要返回Object即可，让调用者自己进行强转
		Object instance = constructor.newInstance(new MyModel()); //这里最后还需要修改扩展性，这里写死了传入一个实现类
//		instance.move();
		return instance;
	}

}
