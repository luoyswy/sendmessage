/**
 * 
 */
package cn.com.yiyuan.annoandenum.enums;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file MessageAccountEnum.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.annoandenum.enums
 * @summary java类
 * 
 */
public enum MessageAccountEnum {
	TAG("tagAccount"),TYPE("type");
	private String value;
	private MessageAccountEnum(String value) {
		this.value = value;
	}
	public String value() {
		return this.value;
	}
}
