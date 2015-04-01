/**
 * 
 */
package com.bdqn.minitxt.common;

/**
 * @ClassName: ClientConstant
 * @Description: 客户端的常量
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午8:47:19
 * 
 */
public interface ClientConstant {

	String SERVER_NAME = "127.0.0.1";
	int SERVER_PORT = 8800;

	// 用户管理模块操作
	String USER_REGIST_STATUS = "2";// 注册
	String USER_LOGIN_STATUS = "1";// 登录
	String USER_SEARCH_STATUS = "4";// 查询
	String USER_EXIT_STATUS = "3";// 退出

	// 用户管理模块
	String WELCOME_INFO = "欢迎使用在线迷你TXT小说管理器\n";
	String LINE1 = "-----------------------------------------------------\n";
	String USER_LOGIN = "1.登陆\n";
	String USER_REGIST = "2.注册\n";
	String USER_EXIT = "3.退出\n";
	String USER_CHOOSE = "请选择：";
	StringBuffer WELCOME_INFOS = new StringBuffer(WELCOME_INFO).append(LINE1)
			.append(USER_LOGIN).append(USER_REGIST).append(USER_EXIT)
			.append(LINE1).append(USER_CHOOSE);

	// 用户注册
	String LINE2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	String USER_REGIST_INFO = "当前操作：注册用户\n";
	String PLEASE_INPUT_USERNAME = "请输入登录名：";
	String PLEASE_INPUT_PASSWORD = "请输入密码：";
	String PLEASE_REINPUT_PASSWORD = "请再次输入密码：";
	StringBuffer USER_REGIST_INFOS = new StringBuffer(LINE2)
			.append(USER_REGIST_INFO).append(LINE2)
			.append(PLEASE_INPUT_USERNAME);

	// 用户登录
	String USER_LOGIN_INFO = "当前操作：用户登录\n";
	StringBuffer USER_LOGIN_INFOS = new StringBuffer(LINE2)
			.append(USER_LOGIN_INFO).append(LINE2)
			.append(PLEASE_INPUT_USERNAME);
	String LINE3 = "*****************************************************\n";
	String LOGIN_SUCCESS = "登陆成功！\n";
	String USER_RETURN_UPPER_LEVEL = "0.返回上级菜单\n";
	String MARTIAL_ARTS_MENU = "1.武侠\n";
	String ROMANCE_MENU = "2.言情\n";
	StringBuffer LOGIN_SUCCESS_INFOS = new StringBuffer(LINE3)
			.append(LOGIN_SUCCESS).append(LINE3);
	StringBuffer NOVEL_MENU = new StringBuffer(LINE1).append(USER_RETURN_UPPER_LEVEL)
			.append(MARTIAL_ARTS_MENU).append(ROMANCE_MENU).append(LINE1)
			.append(USER_CHOOSE);
}
