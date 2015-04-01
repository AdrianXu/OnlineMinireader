package com.bdqn.minitxt.novel.dao;

import java.util.Set;

import com.bdqn.minitxt.novel.entity.Novel;

/**
 * 
 * @ClassName: NovelDao
 * @Description: 小说模块持久层操作
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午9:37:43
 * 
 */
public interface NovelDao {
	/**
	 * 保存小说
	 */

	void saveNovel(Novel novel);

	/**
	 * 查询类别下左右小说
	 */
	Set<Novel> findNovels(String catogory);

	/**
	 * 查询小说（上传下载在线阅读根据小说名）
	 */
	boolean findNovelByName(String name);

	/**
	 * 更新小说
	 */
	void updataNovel(Novel novel);
}
