/**
 * 
 */
package cn.com.yiyuan.application.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.yiyuan.annoandenum.enums.ParamsFixaCon;
import cn.com.yiyuan.application.SendMessageInterface;
import cn.com.yiyuan.server.api.YyMessageAccountService;
import cn.com.yiyuan.server.api.YyMessageLogService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YiYuanExcute.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.application.proxy
 * @summary java类
 * 
 */
@Component
public class YiYuanExcute {
	
	@Resource(name = "YyMessageAccountService")
	private YyMessageAccountService yyMessageAccountService;
	@Resource(name = "YyMessageLogService")
	private YyMessageLogService yyMessageLogService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object excute(Class<?> cla,Map datas) throws Exception {
		datas.put(ParamsFixaCon.ACCOUNTSERVICE.value(), yyMessageAccountService);
		datas.put(ParamsFixaCon.LOGSERVICE.value(), yyMessageLogService);
		Class<?>[] interfaces = {SendMessageInterface.class};
		InvocationHandler handler = new YiYuanProxy(cla.newInstance());
		SendMessageInterface sendMessage = (SendMessageInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(), 
				interfaces,handler);
		return sendMessage.sendMessage(datas);
	}
}
