/**
 * 
 */
package com.bdqn.minitxt.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @主题：在线迷你阅读器
 * @Description: 用户类
 * @author Adrian Xu
 * @date 2014年3月25日 下午4:22:49
 * 
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;// 用户名
	private String password;// 密码
	private String status;// 1.登录 2.注册 3.退出
	private boolean result;// true成功 false 失败
	private int loginTimes;// 登录次数
	private Date lastLoginTime;// 最后登录时间
	private Date registTime;// 注册时间
	private int role;// 0：管理员 1.普通用户

	public User() {
		super();
	}

	public User(String name, String password, String status,
			int loginTimes, Date lastLoginTime, Date registTime, int role) {
		super();
		this.name = name;
		this.password = password;
		this.status = status;
		this.loginTimes = loginTimes;
		this.lastLoginTime = lastLoginTime;
		this.registTime = registTime;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
