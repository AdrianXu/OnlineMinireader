/**
 * 
 */
package com.bdqn.minitxt.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.bdqn.minitxt.common.ClientConstant;

/**
 * @ClassName: ClientRequest
 * @Description: 客户端类
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午8:45:02
 * 
 */
public class ClientRequest {

	public <T> T requestToServer(T t) {
		try (Socket client = new Socket(ClientConstant.SERVER_NAME,
				ClientConstant.SERVER_PORT);
		// 向服务器端发送对象
				ObjectOutputStream oos = new ObjectOutputStream(
						client.getOutputStream());
				// 接收服务器端处理后的对象
				ObjectInputStream ois = new ObjectInputStream(
						client.getInputStream());) {

			oos.writeObject(t);
			client.shutdownOutput();
			oos.flush();

			T obj = (T) ois.readObject();
			client.shutdownInput();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
