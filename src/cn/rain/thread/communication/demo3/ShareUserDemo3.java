package cn.rain.thread.communication.demo3;

/**
 * description: 生产线程和消费线程的共享共享数据。
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ShareUserDemo3 {
	private String username;
	private String gender;
	private boolean flag;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "ShareUserDemo3 [username=" + username + ", gender=" + gender + ", flag=" + flag + "]";
	}
}
