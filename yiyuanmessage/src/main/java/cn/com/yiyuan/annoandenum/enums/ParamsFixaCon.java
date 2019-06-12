/**
 * 
 */
package cn.com.yiyuan.annoandenum.enums;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file ParamsFixaCon.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.annoandenum.enums
 * @summary java类
 * 
 */
public enum ParamsFixaCon {
	CLASSTYPE("classType"),
	ACCOUNTSERVICE("accountService"),
	LOGSERVICE("logService")
	;
	private String value;
	private ParamsFixaCon(String value) {
		this.value = value;
	}
	public String value() {
		return this.value;
	}
}
