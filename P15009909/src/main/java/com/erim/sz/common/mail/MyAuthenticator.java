package com.erim.sz.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @ClassName: MyAuthenticator 
 * @Description: 邮件认证
 * @author maoxian
 * @date 2015年11月30日 下午8:46:07
 */
public class MyAuthenticator extends Authenticator {
	
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
