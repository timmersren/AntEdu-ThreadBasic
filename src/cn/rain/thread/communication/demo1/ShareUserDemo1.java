package cn.rain.thread.communication.demo1;

/**
 * 线程间的共享数据
 */
public class ShareUserDemo1 {
	
	private String username;
	private String gender;
	
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
	@Override
	public String toString() {
		return "ShareUser [username=" + username + ", gender=" + gender + "]";
	}
	
}
