package com.bdqn.minitxt.novel.service;

import com.bdqn.minitxt.novel.entity.Novel;

/**
 * 
 * @ClassName: NovelService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 上午9:58:23
 * 
 */
public interface NovelService {
	/**
	 * 查询小说（根据名字）
	 */
	void searchNovelByName(Novel novel);

	/**
	 * 上传小说
	 */
	void uploadNovel(Novel novel);

	/**
	 * 下载小说
	 */
	void downloadNovel(Novel novel);

	/**
	 * 查询小说列表
	 */
	void listNovel(Novel novel);

	/**
	 * 在线阅读小说
	 */
	void onlineReadNovel(Novel novel);
}
