/**
 * 
 */
package cn.com.yiyuan.annoandenum.enums;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file MessageLogEnum.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.annoandenum.enums
 * @summary java类
 * 
 */
public enum MessageLogEnum {
	FAILD(0),SUCCESS(1);
	private Integer value;
	private MessageLogEnum(Integer value) {
		this.value = value;
	}
	public Integer value() {
		return this.value;
	}
}
