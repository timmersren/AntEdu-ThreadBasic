package cn.rain.design.proxy.demo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * description: 我们将一段字符串先写出到文件CompileTimeProxyTank.java,
 * 然后通过JavaCompile将生成的.java进行编译。通过这种方法，我们就不用再自己写代理类了。
 * 但是现在我们还缺少一个步骤，我们知道new User();这句话做的事是 编译User.java生成
 * User.class文件，然后将User.class加载到内存中。因此这里我们还需要将CompileTimeProxyTank.class
 * 加载到内存中，这里就需要用到反射技术了。
 * @author 任伟
 * @date 2018-03-19 16:53:36
 */
public class CompileTest {
	public static void main(String[] args) throws IOException {
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
	}
}
