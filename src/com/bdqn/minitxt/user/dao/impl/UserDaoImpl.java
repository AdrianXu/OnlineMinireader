package com.bdqn.minitxt.user.dao.impl;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.bdqn.minitxt.common.ServerConstant;
import com.bdqn.minitxt.user.dao.UserDao;
import com.bdqn.minitxt.user.entity.User;
import com.bdqn.minitxt.utils.DataFormatUtils;
import com.bdqn.minitxt.utils.XMLUtils;

/**
 * 
 * @ClassName: UserDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月26日 下午4:20:09
 * 
 */
public class UserDaoImpl implements UserDao {

	private File file = new File(ServerConstant.USER_XML_PATH);
	private Document doc = XMLUtils.getDocument(file);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.user.dao.UserDao#saveUser(com.bdqn.minitxt.user.entity
	 * .User)
	 */
	@Override
	public void saveUser(User user) {

		Element root = doc.getRootElement();
		Element levelOne = root.addElement("user");
		Element name = levelOne.addElement("name");
		name.setText(user.getName());
		Element password = levelOne.addElement("password");
		password.setText(user.getPassword());
		Element status = levelOne.addElement("status");
		status.setText(user.getStatus());
		Element loginTimes = levelOne.addElement("loginTimes");
		loginTimes.setText(user.getLoginTimes() + "");
		Element registTime = levelOne.addElement("registTime");
		registTime.setText(DataFormatUtils.getStringFormatDate(user
				.getRegistTime()));
		Element lastLoginTime = levelOne.addElement("lastLoginTime");
		lastLoginTime.setText("");// 注册的时候为空
		Element role = levelOne.addElement("role");
		role.setText(user.getRole() + "");
		user.setResult(true);
		XMLUtils.writeToXml(doc, file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bdqn.minitxt.user.dao.UserDao#findUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean findUser(String userName, String password) {
		Node userElement = findSpecialUser(userName, password);
		if (userElement != null) {
			return true;
		}
		return false;
	}

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	private Node findSpecialUser(String userName, String password) {
		Element root = doc.getRootElement();
		String queryStr = "//user[name='" + userName + "' and password='"
				+ password + "']";
		Node userElement = root.selectSingleNode(queryStr);
		return userElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bdqn.minitxt.user.dao.UserDao#findUserByName(java.lang.String)
	 */
	@Override
	public boolean findUserByName(String userName) {
		Element root = doc.getRootElement();
		String quryStr = "//users/user[name='" + userName + "']";
		Node userElement = root.selectSingleNode(quryStr);
		if (userElement != null) {
			return true;
		}
		return false;
	}

	@Override
	public void updateUser(User user) {
		Node userElement = findSpecialUser(user.getName(), user.getPassword());
		if (userElement != null) {
			// 登陆状态
			userElement.selectSingleNode("status").setText(user.getStatus());
			// 登录次数
			Node loginTimes = userElement.selectSingleNode("loginTimes");
			int times = new Integer(loginTimes.getText());
			loginTimes.setText(++times + "");

			userElement.selectSingleNode("lastLoginTime")
					.setText(
							DataFormatUtils.getStringFormatDate(user
									.getLastLoginTime()));
			user.setResult(true);
			XMLUtils.writeToXml(doc, file);
		} else {
			user.setResult(false);
		}

	}

}
