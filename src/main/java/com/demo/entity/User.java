package com.demo.entity;

/**
 * 用户
 * @author 叶金雄
 * @date 2019年1月23日 下午3:01:50
 */
public class User {
	private String id;
	private String loginName;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
