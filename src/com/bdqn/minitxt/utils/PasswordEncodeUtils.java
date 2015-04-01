/**
 * 
 */
package com.bdqn.minitxt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: PasswordEncodeUtils
 * @Description: 密码进行加密
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月26日 上午12:01:24
 * 
 */
public class PasswordEncodeUtils {

	public static String getMD5EncodeAfterPwd(String pwd) {

		// md5加密算法
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] pwdBytes = md.digest(pwd.getBytes());

			// 在JDK中不可以使用
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(pwdBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
