/**
 * 
 */
package cn.com.yiyuan.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YiYuanBeanManager.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.config
 * @summary java类
 * 
 */
@Configuration
public class YiYuanBeanManager {
	
	@SuppressWarnings("rawtypes")
	@Bean(name = "sendMessageBean")
	public Map getSendMessageBean() {
		return new HashMap<>();
	}
	
}
