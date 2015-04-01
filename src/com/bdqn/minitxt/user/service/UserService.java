package com.bdqn.minitxt.user.service;

import com.bdqn.minitxt.user.entity.User;

public interface UserService {
	/**
	 * 用户查询(根据名字查询）
	 */
	void searchUserByName(User user);

	/**
	 * 用户注册
	 */
	void userRegist(User user);

	/**
	 * 用户登录
	 */
	void userLogin(User user);
}
