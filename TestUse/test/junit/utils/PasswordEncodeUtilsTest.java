/**
 * 
 */
package test.junit.utils;

import org.junit.Test;

import com.bdqn.minitxt.utils.PasswordEncodeUtils;

/**
 * @ClassName: PasswordEncodeUtilsTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月27日 上午8:17:34
 * 
 */
public class PasswordEncodeUtilsTest {

	@Test
	public void getMD5EncodeAfterPwd() {
		String password = "abcdefg";
		System.out.println(PasswordEncodeUtils.getMD5EncodeAfterPwd(password));
	}

}
