package cn.rain.design.proxy.demo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import cn.rain.design.proxy.demo1.model.Movable;
import cn.rain.design.proxy.demo1.model.Tank;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * description: 在demo1中我们知道了，如果我们想实现对于可移动物体（即实现了Movable接口的类）的日志或者打印时间的代理，
 * 我们就需要像LogProxyTank这样的类来实现代理。如果我们有100种需求，就要有100个这样的类，那么我们看下面这段代码。
 * 现在我把LogProxyTank作为字符串拷贝过来了，如果我们能通过某种方法，将下面这段字符当成代码来将其编译，那么不就有了一个代理类了吗。
 * 在jdk6以后，java中新增加的JavaCompiler类可以完成这个功能。除JDK外，一些第三方库也能实现该功能，其中应用最多的就是CGLib和ASM。
 * spring中的AOP就是基于CGLib来实现的，CGLib是基于ASM实现的。我们先使用JDK自带的JavaCompiler进行测试。
 * 
 * 我们将一段字符串先写出到文件CompileTimeProxyTank.java,然后通过JavaCompile将生成的.java进行编译。通过这种方法，我们就不用再自己写代理类了。
 * 但是现在我们还缺少一个步骤，我们知道new User();这句话做的事是编译User.java生成User.class文件，然后将User.class加载到内存中。
 * 因此这里我们还需要将CompileTimeProxyTank.class加载到内存中，这里就需要用到反射技术了。
 * @author 任伟
 * @date 2018-03-19 16:53:36
 */
public class CompileTest {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String rt = "\r\n";
		String src =
				"package cn.rain.design.proxy.demo2;" + rt +
				"import cn.rain.design.proxy.demo1.model.Movable;" + rt + rt +
				"// 这是由CompileTest生成的java文件，并且已经进行了编译！！！" + rt +
				"public class CompileTimeProxyTank implements Movable {" + rt + rt +
				"	private Movable moveableThing;" + rt + rt +
				"	public CompileTimeProxyTank(Movable moveableThing) {" + rt + 
				"		this.moveableThing = moveableThing;" + rt +
				"	}" + rt + rt +
				"	@Override"+ rt + 
				"	public void move() {" + rt + 
				"		System.out.println(\"logger is start!\");" + rt + 
				"		moveableThing.move();" + rt + 
				"		System.out.println(\"logger is end!\");" +  rt + 
				"	}" + rt +  
				"}" ;
		
		// 从系统中获取项目所在路径
		String projectPath = System.getProperty("user.dir");
		// 通过项目路径拼成一个路径，该路径与本类路径相同
		String filePath = projectPath + "/src/cn/rain/design/proxy/demo2/CompileTimeProxyTank.java";
		
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
			clazz = urlClassLoader.loadClass("cn.rain.design.proxy.demo2.CompileTimeProxyTank");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			urlClassLoader.close();
		}
		// 通过反射获取实例
		Constructor<?> constructor = clazz.getConstructor(Movable.class);
		Movable instance = (Movable)constructor.newInstance(new Tank());
		instance.move();
	}
}
