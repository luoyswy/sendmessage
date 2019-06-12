/**
 * 
 */
package cn.com.yiyuan.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import cn.com.yiyuan.application.proxy.YiYuanFindClass;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file AppInitConfig.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.config
 * @summary java类
 * 
 */
@Configuration
public class AppInitConfig implements InitializingBean {

	@Resource
	private YiYuanFindClass yiYuanFindClass;
	@Resource
	private PackagesPojo packagesPojo;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		yiYuanFindClass.registerClass();
	}

}
