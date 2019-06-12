/**
 * 
 */
package cn.com.yiyuan.application.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file EmailAuthentication.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.application.email
 * @summary java类
 * 
 */
public class EmailAuthentication extends Authenticator {
	
	private String username;
	private String password;

	/**
	 * 
	 */
	public EmailAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 */
	public EmailAuthentication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(username, password);
	}
	
}
