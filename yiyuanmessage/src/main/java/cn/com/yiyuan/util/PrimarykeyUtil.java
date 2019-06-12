/**
 * 
 */
package cn.com.yiyuan.util;

import java.util.Date;
import java.util.Random;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file PrimarykeyUtil.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.util
 * @summary java类
 * 
 */
public class PrimarykeyUtil {
	
	public static Long getKey() {
		Long id = (new Date()).getTime();
		Random random = new Random();
		int rand = random.nextInt(10000);
		String strId = "" + id + "" + rand;
		return Long.parseLong(strId);
	}
	
}
