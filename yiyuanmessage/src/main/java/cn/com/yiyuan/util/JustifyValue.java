/**
 * 
 */
package cn.com.yiyuan.util;

import cn.com.yiyuan.annoandenum.anno.TagSendMessageAnno;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file JustifyValue.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.util
 * @summary java类
 * 
 */
public class JustifyValue {
	
	public static boolean justifyTypeEqClaTag(Class<?> cla,String type) {
		if(type == null || "".equals(type)) return false;
		TagSendMessageAnno tag = cla.getAnnotation(TagSendMessageAnno.class);
		if(tag == null || "".equals(tag.tag())) return false;
		if(type.equals(tag.tag())) return true;
		return false;
	}
	
}
