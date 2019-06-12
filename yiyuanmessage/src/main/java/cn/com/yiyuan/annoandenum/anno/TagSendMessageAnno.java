/**
 * 
 */
package cn.com.yiyuan.annoandenum.anno;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file TagSendMessageAnno.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.annoandenum
 * @summary java类
 * 
 */
public @interface TagSendMessageAnno {
	
	String tag() default "";
	
}
