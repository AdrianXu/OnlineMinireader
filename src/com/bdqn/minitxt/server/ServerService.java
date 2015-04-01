package com.bdqn.minitxt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.bdqn.minitxt.common.ServerConstant;

/**
 * 
 * @ClassName: ServerService
 * @Description: 服务器端服务类
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午8:46:18
 * 
 */
public class ServerService<T> {
	/**
	 * 响应客户端的请求
	 */
	public void responseToClient() {

		try {
			ServerSocket server = new ServerSocket(ServerConstant.SERVER_PORT);
			while (true) {
				Socket client = server.accept();
				new Thread(new ServerThread<T>(client)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
