/**
 * 
 */
package com.bdqn.minitxt.ui;

import java.util.Date;
import java.util.Scanner;

import com.bdqn.minitxt.client.ClientRequest;
import com.bdqn.minitxt.common.ClientConstant;
import com.bdqn.minitxt.user.entity.User;

/**
 * @ClassName: UserUi
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 下午2:18:23
 * 
 */
public class UserUi {

	public UserUi() {

	}

	public void userOperator() {
		Scanner input = new Scanner(System.in);
		System.out.print(ClientConstant.WELCOME_INFOS);
		String choice = input.nextLine();
		switch (choice) {
		case ClientConstant.USER_LOGIN_STATUS:
			userLogin(input);
			break;
		case ClientConstant.USER_REGIST_STATUS:
			userRegist(input);
			break;
		case ClientConstant.USER_EXIT_STATUS:
			break;
		default:
			System.out.println("您输入的不存在，请重新输入");
			userOperator();
		}
	}

	/**
	 * @param input
	 */
	private void userRegist(Scanner input) {
		while (true) {
			System.out.print(ClientConstant.USER_REGIST_INFOS);
			String name = input.nextLine();
			User user = new User();
			user.setName(name);
			user.setStatus(ClientConstant.USER_SEARCH_STATUS);
			User userFromServer = new ClientRequest().requestToServer(user);
			if (userFromServer.isResult()) {
				System.out.println("用户名已存在");
				continue;
			} else {
				while (true) {
					System.out.print(ClientConstant.PLEASE_INPUT_PASSWORD);
					String password = input.nextLine();
					System.out.print(ClientConstant.PLEASE_REINPUT_PASSWORD);
					String rePassword = input.nextLine();
					if (password.equals(rePassword)) {
						user.setName(name);
						user.setPassword(password);
						user.setStatus(ClientConstant.USER_REGIST_STATUS);
						user.setRegistTime(new Date());
						userFromServer = new ClientRequest()
								.requestToServer(user);
						if (userFromServer.isResult()) {
							userLogin(input);
						}
					} else {
						System.out.println("两次密码不一致，请重新输入");
						continue;
					}
				}
			}
		}
	}

	/**
	 * @param input
	 */
	private void userLogin(Scanner input) {
		while (true) {
			System.out.print(ClientConstant.USER_LOGIN_INFOS);
			String name = input.nextLine();
			System.out.print(ClientConstant.PLEASE_INPUT_PASSWORD);
			String password = input.nextLine();
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setStatus(ClientConstant.USER_LOGIN_STATUS);
			user.setLastLoginTime(new Date());
			// 向服务器发送请求
			User userFromServer = new ClientRequest().requestToServer(user);
			if (userFromServer.isResult()) {
				System.out.println(ClientConstant.LOGIN_SUCCESS_INFOS);
				new NovelUi().NovelList();
				break;
			} else {
				// 用户名错误
				System.out.println("登录失败");
			}
		}
	}
}
