/**
 * 
 */
package com.bdqn.minitxt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bdqn.minitxt.common.ServerConstant;

/**
 * @ClassName: DataFormatUtils
 * @Description: 时间格式处理
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午11:52:48
 * 
 */
public class DataFormatUtils {
	/**
	 * 把时间格式转化成字符串
	 */

	public static String getStringFormatDate(Date date) {
		return new SimpleDateFormat(ServerConstant.TIME_PATH).format(date);
	}

	/**
	 * 把字符串解析日期类型
	 */

	public static Date getDateFromString(String str) {
		try {
			return new SimpleDateFormat(ServerConstant.TIME_PATH).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
