/**
 * 
 */
package com.bdqn.minitxt.start;

import com.bdqn.minitxt.server.ServerService;

/**
 * @ClassName: ServerStart
 * @Description: 服务器端启动
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 下午3:38:14
 * 
 */
public class ServerStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ServerService().responseToClient();
	}

}
