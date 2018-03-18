package cn.rain.design.chainofresponsibility.demo1;

/**
 * description: 敏感词过滤器，将敏感词进行替换和删除
 * @author 任伟
 * @date Mar 18, 2018
 */
public class SensitiveMsgFilter implements MsgFilter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("中国共产党", "我党").replace("马化腾", "***").replaceAll("台湾", "");
	}

}
