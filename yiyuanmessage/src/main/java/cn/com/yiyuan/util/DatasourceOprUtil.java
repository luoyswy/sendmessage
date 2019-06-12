/**
 * 
 */
package cn.com.yiyuan.util;

import cn.com.yiyuan.mapper.YyMessageLogMapper;
import cn.com.yiyuan.pojo.YyMessageLogPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file DatasourceOprUtil.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.util
 * @summary java类
 * 
 */
public class DatasourceOprUtil {
	
	public static synchronized void insertMessageLog(YyMessageLogPojo yyMessageLogPojo,YyMessageLogMapper messageLogMapper) throws Exception {
		Long id = PrimarykeyUtil.getKey();
		while(true) {
			YyMessageLogPojo logPojo = messageLogMapper.selectMessageLogById(id);
			if(logPojo == null) break;
		}
		yyMessageLogPojo.setId(id);
		messageLogMapper.insertMessageLog(yyMessageLogPojo);		
	}
	
}
