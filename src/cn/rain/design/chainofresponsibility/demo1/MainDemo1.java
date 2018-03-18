package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 我们现在想设计这样一个过滤去，将传入的字符串进行敏感词替换、敏感词删除等等。
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MainDemo1 {
	public static void main(String[] args) {
		String msg = "<马化腾>不是台湾人，而是深圳人，哈哈= =，他是中国共产党党员。";
		MsgProcesor msgProcesor = new MsgProcesor();
		String result = msgProcesor.process(msg);
		System.out.println(result);
	}
}
