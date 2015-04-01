package com.bdqn.minitxt.user.service.impl;

import com.bdqn.minitxt.user.dao.UserDao;
import com.bdqn.minitxt.user.entity.User;
import com.bdqn.minitxt.user.service.UserService;
import com.bdqn.minitxt.utils.InstanceFactory;
import com.bdqn.minitxt.utils.PasswordEncodeUtils;

public class UserServiceImpl implements UserService {

	private UserDao dao = (UserDao) InstanceFactory.getInstance()
			.createInstance(UserDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.user.service.UserService#userRegist(com.bdqn.minitxt
	 * .user.entity.User)
	 */
	@Override
	public void userRegist(User user) {

		user.setPassword(PasswordEncodeUtils.getMD5EncodeAfterPwd(user
				.getPassword()));
		dao.saveUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.user.service.UserService#userLogin(com.bdqn.minitxt.
	 * user.entity.User)
	 */
	@Override
	public void userLogin(User user) {
		user.setPassword(PasswordEncodeUtils.getMD5EncodeAfterPwd(user
				.getPassword()));
		dao.updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.user.service.UserService#searchUserByName(com.bdqn.minitxt
	 * .user.entity.User)
	 */
	@Override
	public void searchUserByName(User user) {
		user.setResult(dao.findUserByName(user.getName()));

	}

}
