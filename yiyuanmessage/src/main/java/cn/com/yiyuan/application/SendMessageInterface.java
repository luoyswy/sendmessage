/**
 * 
 */
package cn.com.yiyuan.application;

import java.util.Map;

import cn.com.yiyuan.pojo.StatusResultEntity;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessageInterface.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.application
 * @summary java类
 * 
 */
public interface SendMessageInterface {
	
	@SuppressWarnings("rawtypes")
	public StatusResultEntity sendMessage(Map data) throws Exception;
	
}
