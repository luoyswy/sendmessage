/**
 * 
 */
package cn.com.yiyuan.server.api;

import java.util.Map;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YySendMessageService.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.api
 * @summary java类
 * 
 */
public interface YySendMessageService {
	
	@SuppressWarnings("rawtypes")
	public Object sendMessage(Map datas) throws Exception;
	
}
