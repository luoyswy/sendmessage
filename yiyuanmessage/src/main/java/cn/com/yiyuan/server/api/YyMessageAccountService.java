/**
 * 
 */
package cn.com.yiyuan.server.api;

import cn.com.yiyuan.pojo.YyMessageAccountPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageAccountService.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.api
 * @summary java类
 * 
 */
public interface YyMessageAccountService {
	
	public YyMessageAccountPojo selectMessageAccountByTag(String tag,String type) throws Exception;
	
}
