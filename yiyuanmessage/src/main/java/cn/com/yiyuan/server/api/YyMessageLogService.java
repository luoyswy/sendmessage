/**
 * 
 */
package cn.com.yiyuan.server.api;

import cn.com.yiyuan.pojo.YyMessageLogPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageLogService.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.api
 * @summary java类
 * 
 */
public interface YyMessageLogService {
	
	public YyMessageLogPojo insertMessageLog(YyMessageLogPojo yyMessageLogPojo) throws Exception;
	
	public void updateMessageLogStatusByid(YyMessageLogPojo yyMessageLogPojo) throws Exception;
	
	public YyMessageLogPojo selectMessageLogById(Long id) throws Exception;
	
}
