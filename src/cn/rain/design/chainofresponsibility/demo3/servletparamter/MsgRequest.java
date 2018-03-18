package cn.rain.design.chainofresponsibility.demo3.servletparamter;

/**
 * description: 
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MsgRequest {
	private String requestStr;

	public String getRequestStr() {
		return requestStr;
	}

	public void setRequestStr(String requestStr) {
		this.requestStr = requestStr;
	}

	@Override
	public String toString() {
		return "MsgRequest [requestStr=" + requestStr + "]";
	}
}
