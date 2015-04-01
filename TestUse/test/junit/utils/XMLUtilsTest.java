/**
 * 
 */
package test.junit.utils;

import java.io.File;

import org.dom4j.Document;
import org.junit.Test;

import com.bdqn.minitxt.utils.XMLUtils;

/**
 * @ClassName: XMLUtilsTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午5:45:48
 * 
 */
public class XMLUtilsTest {

	private File file = new File("config/user.xml");

	@Test
	public void testGetDocument() {
		System.out.println(XMLUtils.getDocument(file));
	}

	@Test
	public void testWriteToXml() {
		Document doc = XMLUtils.getDocument(file);
		XMLUtils.writeToXml(doc, file);
	}

}
