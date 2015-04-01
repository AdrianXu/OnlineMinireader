/**
 * 
 */
package test.junit.utils;

import java.util.Date;

import org.junit.Test;

import com.bdqn.minitxt.utils.DataFormatUtils;

/**
 * @ClassName: DataFormatUtilsTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 上午8:13:08
 * 
 */
public class DataFormatUtilsTest {

	@Test
	public void getStringFormatDate() {
		Date date = new Date();
		System.out.println(DataFormatUtils.getStringFormatDate(date));
	}

	@Test
	public void getDateFromString() {
		String str = "2014-03-27 08:15:37";
		System.out.println(DataFormatUtils.getDateFromString(str));
	}

}
