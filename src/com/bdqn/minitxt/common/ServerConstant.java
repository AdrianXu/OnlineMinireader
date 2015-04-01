/**
 * 
 */
package com.bdqn.minitxt.common;

/**
 * @ClassName: ServerConstant
 * @Description: 服务器端的常量
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午8:48:04
 * 
 */
public interface ServerConstant {
	// xml文件路径
	String USER_XML_PATH = "config\\user.xml";
	String NOVEL_XML_PATH = "config\\novels.xml";

	// 时间格式
	String TIME_PATH = "yyyy-MM-dd HH:mm:ss";

	// 在线阅读字数
	int CONTENT_SIZE = 500;

	// 小说模块操作
	String NOVEL_MARTIALARTS_MENU = "1";
	String NOVEL_ROMANCE_MENU = "2";
	String NOVEL_RETURN_UPPER_LEVEL = "0";

	// 小说状态
	String NOVEL_ONLINE_READ = "3";
	String NOVEL_DOWNLOAD = "2";
	String NOVEL_UPLOAD = "1";
	String NOVEL_RETURN = "0";
	String NOVEL_LIST = "4";
	String NOVEL_SEARCH = "5";

	// 小说类别
	String NOVEL_MARTIAL_ARTS = "1";
	String NOVEL_ROMANCE = "2";

	// 武侠小说
	String LINE1 = "---------------------武侠小说列表---------------------\n";
	String LINE2 = "---------------------小说列表结束---------------------\n";

	// 小说操作
	String NOVEL_OPERATION = "在线阅读txt请输入3，下载TXT请输入2，上传TXT请输入1，返回请输入0：";
	String PLEASE_INPUT_UPLOAD_NAME = "请输入小说名：";
	String PLEASE_INPUT_UPLOAD_AUTHOR = "请输入作者：";
	String PLEASE_INPUT_UPLOAD_INDRODUCTION = "请输入简介：";
	String PLEASE_INPUT_UPLOAD_PATH = "请输入上传的小说路径.txt（请注意路径用/或者\\）:";
	String NOVEL_UPLOAD_SUCESS = "小说上传成功！\n";
	String LINE3 = "*****************************************************\n";
	String CONTINUE_UPLOAD_OR_BACK = "继续上传请输入1，返回请输入0：";
	StringBuffer NOVEL_UPLOAD_SUCESSES = new StringBuffer(LINE3)
			.append(NOVEL_UPLOAD_SUCESS).append(LINE3).append(CONTINUE_UPLOAD_OR_BACK);
	String PLEASE_INPUT_DOWNLOAD_NAME = "请输入要下载的小说名：";
	String PLEASE_INPUT_DOWNLOAD_PATH = "请输入您要下载到本地的小说路径（请注意路径用/或者\\，※若不输入默认下载到本地磁盘的路径是D:\\TEMP\\）：";
	String DOWNLOAD_NAME = "下载后的文件名是：";
	String DOWNLOAD_PATH = "下载后的路径是：";
	String DOWNLOAD_RESULT = "文件下载结果：";
	String CONTINUE_DOWNLOAD_OR_BACK = "继续下载请输入1，返回请输入0或其他：";
	StringBuffer CONTINUE_OR_BACKS = new StringBuffer(LINE3)
			.append(CONTINUE_DOWNLOAD_OR_BACK);
	String PLEASE_INPUT_READ_NAME = "请输入您要阅读的小说名：";
	String CURRENT_OPERATIONS = "当前操作：阅读\n";
	String NOVEL_MESSAGE = "===========小说摘要信息如下：===========\n";
	StringBuffer NOVEL_MESSAGES = new StringBuffer(LINE3).append(
			CURRENT_OPERATIONS).append(NOVEL_MESSAGE);
	String CONTINUE_SHOW_OR_DOWNLOAD = "继续显示列表请输入0，下载TXT请输入1,返回输入其他：";
	StringBuffer CONTINUE_SHOW_OR_DOWNLOADS = new StringBuffer(LINE3)
			.append(CONTINUE_SHOW_OR_DOWNLOAD);
	// 在线阅读默认本地路径：借用一下文件名，内容在缓存中
	String DEFAULT_FILE_PATH = "D:/temp/";
	String MARTIAL_PATH="Story/Martial arts/";
	String ROMANCE_PATH="Story/Romance/";

	// 服务器端端口号
	int SERVER_PORT = 8800;

	// 当前用户操作
	String USER_REGIST_COMMAND = "命令是：用户注册";
	String USER_LOGIN_COMMAND = "命令是：用户登录";
	String USER_SEARCH_COMMAND = "命令是：用户查询";
	String NOVEL_LIST_COMMAND = "命令是：显示小说列表";
	String NOVEL_SEARCH_COMMAND = "命令是：查询小说";
	String NOVEL_ONLINEREAD_COMMAND = "命令是：在线阅读";
	String NOVEL_DOWNLOAD_COMMAND = "命令是：小说下载";
	String NOVEL_UPLOAD_COMMAND = "命令是：小说上传";
	// 用户管理模块的操作

	String USER_REGIST_STATUS = "2";// 注册
	String USER_LOGIN_STATUS = "1";// 登录
	String USER_EXIT_STATUS = "3";// 退出
	String USER_SEARCH_STATUS = "4";// 查找
}
