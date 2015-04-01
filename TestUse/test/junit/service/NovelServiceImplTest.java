/**
 * 
 */
package test.junit.service;

import org.junit.Test;

import com.bdqn.minitxt.novel.dao.NovelDao;
import com.bdqn.minitxt.novel.entity.Novel;
import com.bdqn.minitxt.utils.InstanceFactory;

/** 
 * @ClassName: NovelServiceImplTest 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月28日 下午2:29:02 
 *  
 */
public class NovelServiceImplTest {
	private NovelDao dao = (NovelDao) InstanceFactory.getInstance()
			.createInstance(NovelDao.class);

	@Test
	public void uploadNovel(Novel novel) {

		dao.saveNovel(novel);
	}

	@Test
	public void downloadNovel(Novel novel) {

		dao.updataNovel(novel);
	}

	@Test
	public void listNovel(Novel novel) {

		novel.setNovels(dao.findNovels(novel.getCatogory()));
	}

	@Test
	public void searchNovelByName(Novel novel) {

		novel.setResult(dao.findNovelByName(novel.getName()));
	}
	
	@Test
	public void onlineReadNovel(Novel novel) {

		dao.updataNovel(novel);
	}


}
