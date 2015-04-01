/**
 * 
 */
package com.bdqn.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

import com.bdqn.minitxt.common.ServerConstant;
import com.bdqn.minitxt.novel.entity.Novel;
import com.bdqn.minitxt.novel.service.NovelService;
import com.bdqn.minitxt.user.entity.User;
import com.bdqn.minitxt.user.service.UserService;
import com.bdqn.minitxt.utils.DataFormatUtils;
import com.bdqn.minitxt.utils.InstanceFactory;

/**
 * @ClassName: ServerThread
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 下午1:52:01
 * 
 */
public class ServerThread<T> implements Runnable {

	private Socket client;

	public ServerThread() {

	}

	public ServerThread(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		try (ObjectInputStream ois = new ObjectInputStream(
				client.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(
						client.getOutputStream());) {
			InetAddress ia = client.getInetAddress();
			// 读对象
			T obj = (T) ois.readObject();
			client.shutdownInput();
			// 用户管理模块
			if (obj instanceof User) {
				UserService service = (UserService) InstanceFactory
						.getInstance().createInstance(UserService.class);
				User user = (User) obj;
				switch (user.getStatus()) {
				case ServerConstant.USER_REGIST_STATUS:
					System.out.print(ServerConstant.USER_REGIST_COMMAND);
					System.out.println(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					service.userRegist(user);
					break;
				case ServerConstant.USER_LOGIN_STATUS:
					System.out.println(ServerConstant.USER_LOGIN_COMMAND);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					service.userLogin(user);
					break;
				case ServerConstant.USER_SEARCH_STATUS:
					System.out.println(ServerConstant.USER_SEARCH_COMMAND);
					service.searchUserByName(user);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				case ServerConstant.USER_EXIT_STATUS:
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				}
			}
			// 小说管理模块
			if (obj instanceof Novel) {
				NovelService service = (NovelService) InstanceFactory
						.getInstance().createInstance(NovelService.class);
				Novel novel = (Novel) obj;
				switch (novel.getStatus()) {
				case ServerConstant.NOVEL_LIST:
					System.out.println(ServerConstant.NOVEL_LIST_COMMAND);
					service.listNovel(novel);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				case ServerConstant.NOVEL_UPLOAD:
					System.out.println(ServerConstant.NOVEL_UPLOAD_COMMAND);
					service.uploadNovel(novel);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				case ServerConstant.NOVEL_DOWNLOAD:
					System.out.println(ServerConstant.NOVEL_DOWNLOAD_COMMAND);
					service.downloadNovel(novel);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				case ServerConstant.NOVEL_ONLINE_READ:
					System.out.println(ServerConstant.NOVEL_ONLINEREAD_COMMAND);
					service.onlineReadNovel(novel);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				case ServerConstant.NOVEL_SEARCH:
					System.out.println(ServerConstant.NOVEL_SEARCH_COMMAND);
					service.searchNovelByName(novel);
					System.out.print(DataFormatUtils
							.getStringFormatDate(new Date()));
					System.out.println("客户端" + ia.getHostName() + "获得了连接");
					break;
				}
			}

			// 写对象
			oos.writeObject(obj);
			oos.flush();
			client.shutdownOutput();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
