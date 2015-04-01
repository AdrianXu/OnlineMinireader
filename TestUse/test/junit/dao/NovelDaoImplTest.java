/** 
 * 
 */
package test.junit.dao;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.junit.Test;

import com.bdqn.minitxt.common.ServerConstant;
import com.bdqn.minitxt.novel.dao.NovelDao;
import com.bdqn.minitxt.novel.entity.Novel;
import com.bdqn.minitxt.utils.InstanceFactory;

/**
 * @ClassName: NovelDaoImplTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月26日 下午2:09:27
 * 
 */
public class NovelDaoImplTest {
	private NovelDao dao = (NovelDao) InstanceFactory.getInstance()
			.createInstance(NovelDao.class);

	@Test
	public void testSaveNovel() {
		String fileName = "Youth" + ".txt";
		Novel novel = new Novel("Youth", "NewEast", "All of us have read ",
				"1", "1", "D:/temp/" + fileName, ServerConstant.MARTIAL_PATH
						+ fileName, 0, null, new Date());
		dao.saveNovel(novel);
	}

	@Test
	public void testFindNovels() {
		Set<Novel> novels = dao.findNovels("1");
		System.out.println(novels);
		System.out.println(novels.size());
	}

	@Test
	public void findNovelByName() {
		String fileName = "Youth";
		System.out.println(dao.findNovelByName(fileName));
	}

	@Test
	public void testUpdateNovel() {
		// 下载
//		Novel novel = new Novel();
//		String fileName = "Youth";
//		novel.setName(fileName);
//		novel.setDownloadTime(new Date());
//		novel.setStatus("2");
//		novel.setTargetDirectory("D:/temp/" + fileName + ".txt");
//		dao.updataNovel(novel);
//		System.out.println(novel.isResult());
		// 在线阅读
		 Novel novel = new Novel();
		 novel.setDownloadTime(new Date());
		 String fileName = "Three Days to See1";
		 novel.setStatus("3");
		 novel.setName(fileName);
		 File dir = new File(ServerConstant.DEFAULT_FILE_PATH);
		 if (!dir.exists()) {
		 dir.mkdir();
		 }
		 String OnlineReadFile = ServerConstant.DEFAULT_FILE_PATH + fileName
		 + ".txt";
		 novel.setTargetDirectory(OnlineReadFile);
		 dao.updataNovel(novel);
		 System.out.println(novel.isResult());
		 System.out.println(novel.getPartContent());
	}
}
