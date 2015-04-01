/**
 * 
 */
package test.junit.ui;

import org.junit.Test;

import com.bdqn.minitxt.ui.UserUi;

/** 
 * @ClassName: UserUiTest 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月28日 下午10:37:21 
 *  
 */
public class UserUiTest {

	UserUi userUi=new UserUi();
	@Test
	public void userOperator() {
		userUi.userOperator();
	}

}
