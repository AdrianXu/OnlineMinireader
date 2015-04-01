package com.bdqn.minitxt.user.dao;

import com.bdqn.minitxt.user.entity.User;

/**
 * 
 * @ClassName: UserDao
 * @Description: 用户持久层操作
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月26日 下午4:15:03
 * 
 */
public interface UserDao {
	/**
	 * 保存用户
	 */
	void saveUser(User user);

	/**
	 * 查询用户（登陆，根据用户名密码）
	 */
	boolean findUser(String userName,String password);
	/**
	 * 查询用户（注册的时候）
	 */
	boolean findUserByName(String userName);
	/**
	 * 更新用户
	 */
	void updateUser(User user);


}
