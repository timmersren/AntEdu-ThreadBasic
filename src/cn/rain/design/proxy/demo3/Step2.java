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

import cn.rain.design.proxy.demo3.handler.MyInvocationHandler;
import cn.rain.design.proxy.demo3.model.MyInterface;
import cn.rain.design.proxy.demo3.model.MyModel;

/**
 * description: 在step1中我们已经完成了对传入接口和该接口中的方法进行了灵活性扩展改造。
 * 在本类中，我们将进行对处理方式的抽取，使其可以由调用者自己决定使用何种处理方式。
 * @author 任伟
 * @date 2018-03-22 16:38:40
 */
public class Step2 {
	public static Object newProxyInstance(Class intface, MyInvocationHandler handler) throws Exception{
		String rt = "\r\n";
		
		String methodStr = "";
		//获取传入接口的方法
		Method[] methods = intface.getMethods();
		//遍历每个方法时都生成代理格式的代码的字符串
		for (Method method : methods) {
			methodStr += "	@Override" + rt +
						 "	public void " +method.getName()+ "() {" + rt + 
						 // 这种写法是不正确的，因为我们在本类得到的method是为了用于拼接字符串。我们知道现在这个类中的东西都是在拼接字符串，然后将字符串写到文件中再进行编译。
						 // 因此我们无法将这里的method传递到一会我们要生成的.java文件中。所以我们需要让那个由字符串拼接而成的.java文件自己获取method。
						 // 由于我们已经将要代理的接口通过拼接字符串的形式写入到了.java文件中，因此我们就要通过这个被代理的接口获取它其中的方法。
						 // 总结一句就是：我们无法将Method对象传入到拼接而成的.java文件，因此我们只能通过字符串拼接成让它在内部自己获取Method对象的方法
//						 "	handler.invoke(this," + method.getName() +")" + rt +
						 
						 "		try{" + rt +
						 "			Method m = " + intface.getName() + ".class.getMethod(\"" +method.getName()+ "\");" + rt +
						 "			handler.invoke(this, m);" + rt + 
						 "		}catch(NoSuchMethodException | SecurityException e){" + rt +
						 "			e.printStackTrace();" + rt + 
						 "		}" + rt + 
						 "	}" + rt + rt ;
		}
		
		String src =
				"package cn.rain.design.proxy.demo3.autocompile;" + rt + rt +
				"import java.lang.reflect.Method;" + rt +
				"import cn.rain.design.proxy.demo3.handler.MyInvocationHandler;" + rt + rt +
				"// 这是由Step2生成的java文件，并且已经进行了编译！！！" + rt +
				//这里如果直接使用intface那么会调用它的toString方法，从而写出的文件中会多一个interface关键字。
				//代理类的名字不重要，其实它完全可以不存在。因此JDK中为这个类命名为$Proxy1
				"public class $Proxy1 implements "+ intface.getName() +"{" + rt + rt +  
				/**
				 * 下面的代码要强调一下，在step1中我们聚合（依赖）的成员变量是被代理的接口，由于在step2中需要handler来定义
				 * 处理方式，但是为什么不是聚合被代理接口和handler这两个成员变量，而是去除了被代理接口？
				 * 由于最终被代理的对象应该是一个被代理接口的实现类，现在的问题是我们在哪里传入这个实现类呢？
				 * 我们可以看一下step1的第107行代码，很明显它在用字符串构造代理对象$Proxy1的时候将被代理接口的实现对象写死在内部了。
				 * 这是绝对不可能的，你定义代理对象时候，具体代理哪个实现类是由调用者（用户）决定的，怎么可能写死在内部呢？
				 * 因此我们在实现InvocationHandler的时候，要求创建实例时必须给出一个被代理的对象（见LoggerInvocationHandler的15行）。
				 * 然后我们在构建代理对象，遍历传入的被代理接口的方法时，对每个遍历到的方法调用handler中的invoke方法进行处理（见本类34行），
				 * 由于调用handler.invoke会传给handler方法名，并且handler内部在new Handler实例时已经接收到了要被代理的对象，
				 * 因此handler就可以对此方法进行处理了。
				 */
				"	private MyInvocationHandler handler;" + rt + rt +
				"	public $Proxy1(MyInvocationHandler handler) {" + rt + 
				"		this.handler = handler;" + rt +
				"	}" + rt + rt +
				methodStr + rt + 
				"}" ;
		
		// 将上面的字符串写入到文件中
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath + "/src/cn/rain/design/proxy/demo3/autocompile/$Proxy1.java";
		File file = new File(filePath);
		FileWriter writer = new FileWriter(file);
		writer.write(src);
		writer.flush();
		writer.close();
		
		// 将生成的文件进行编译、加载
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

		Iterable<? extends JavaFileObject> targerFiles = fileManager.getJavaFileObjects(filePath);
		CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, targerFiles);
		task.call();
		fileManager.close();

		URL[] urlArr = new URL[] { new URL("file:/" + System.getProperty("user.dir") + "/src") };
		URLClassLoader urlClassLoader = new URLClassLoader(urlArr);
		Class<?> clazz = null;
		try {
			// 将该路径的class文件load到内存
			clazz = urlClassLoader.loadClass("cn.rain.design.proxy.demo3.autocompile.$Proxy1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			urlClassLoader.close();
		}

		// 代理对象$Proxy1的构造器需要InvocationHandler
		Constructor<?> constructor = clazz.getConstructor(MyInvocationHandler.class);
		// 由于在这里我们不知道具体传入的接口是什么类型，因此我们只要返回Object即可，让调用者自己进行强转
		Object instance = constructor.newInstance(handler); // 这里最后还需要修改扩展性，这里写死了传入一个实现类
		
		return instance;
	}
}
