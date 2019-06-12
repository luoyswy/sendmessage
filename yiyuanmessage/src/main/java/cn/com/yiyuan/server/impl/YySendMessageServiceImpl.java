/**
 * 
 */
package cn.com.yiyuan.server.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yiyuan.annoandenum.enums.ParamsFixaCon;
import cn.com.yiyuan.application.proxy.YiYuanExcute;
import cn.com.yiyuan.application.proxy.YiYuanFindClass;
import cn.com.yiyuan.server.api.YySendMessageService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YySendMessageServiceImpl.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.impl
 * @summary java类
 * 
 */
@Service("YySendMessageService")
public class YySendMessageServiceImpl implements YySendMessageService {

	@Resource
	private YiYuanFindClass yiYuanFindClass;
	@Resource
	private YiYuanExcute yiYuanExcute;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object sendMessage(Map datas) throws Exception {
		String type = (String) datas.get(ParamsFixaCon.CLASSTYPE.value());
		Class<?> cla = yiYuanFindClass.findClassByType(type);
		if(cla == null) return null;
		Object obj = yiYuanExcute.excute(cla, datas);
		return obj;
	}
}
