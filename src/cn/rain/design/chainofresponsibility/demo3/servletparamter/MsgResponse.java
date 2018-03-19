package cn.rain.design.chainofresponsibility.demo3.servletparamter;

/**
 * description: 
 * @author 任伟
 * @date Mar 18, 2018
 */
public class MsgResponse {
	private String responseMsg;

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	@Override
	public String toString() {
		return "MsgResponse [responseMsg=" + responseMsg + "]";
	}
	
	
}
