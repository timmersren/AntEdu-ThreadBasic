/**
 * 
 */
package cn.rain.thread.basic.example.batch;

/**  
* description:   
* @author 任伟  
* @date Mar 8, 2018
*/
public class User {
	private String userId;
	private String username;
	
	
	public User(String userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
	
	
	
}
