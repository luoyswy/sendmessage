/**
 * 
 */
package cn.com.yiyuan.server.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yiyuan.mapper.YyMessageLogMapper;
import cn.com.yiyuan.pojo.YyMessageLogPojo;
import cn.com.yiyuan.server.api.YyMessageLogService;
import cn.com.yiyuan.util.DatasourceOprUtil;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageLogServiceImpl.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.impl
 * @summary java类
 * 
 */
@Service("YyMessageLogService")
public class YyMessageLogServiceImpl implements YyMessageLogService {

	@Resource
	private YyMessageLogMapper yyMessageLogMapper;
	
	@Override
	public YyMessageLogPojo insertMessageLog(YyMessageLogPojo yyMessageLogPojo) throws Exception {
		DatasourceOprUtil.insertMessageLog(yyMessageLogPojo, yyMessageLogMapper);
		return yyMessageLogPojo;
	}

	@Override
	public void updateMessageLogStatusByid(YyMessageLogPojo yyMessageLogPojo) throws Exception {
		yyMessageLogMapper.updateMessageLogStatusById(yyMessageLogPojo);
	}

	@Override
	public YyMessageLogPojo selectMessageLogById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return yyMessageLogMapper.selectMessageLogById(id);
	}

}
