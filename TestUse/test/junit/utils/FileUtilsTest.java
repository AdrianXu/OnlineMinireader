/**
 * 
 */
package test.junit.utils;

import org.junit.Test;

import com.bdqn.minitxt.novel.entity.Novel;
import com.bdqn.minitxt.utils.FileUtils;

/**
 * @ClassName: FileUitlsTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午5:18:12
 * 
 */
public class FileUtilsTest {

	@Test
	public void testFileCopy() {
		Novel novel = new Novel();

		String targetDirectory = "D:\\Tony\\Documents\\课程下载资料\\实训项目\\Youth.txt";
		String sourceDirectory = "Story\\Martial arts\\Youth.txt";
		novel.setSourceDirectory(sourceDirectory);
		novel.setTargetDirectory(targetDirectory);

		FileUtils.fileCopy(novel);

	}

}
