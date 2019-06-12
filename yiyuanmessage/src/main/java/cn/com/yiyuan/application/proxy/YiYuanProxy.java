/**
 * 
 */
package cn.com.yiyuan.application.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YiYuanProxy.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.application.proxy
 * @summary java类
 * 
 */
public class YiYuanProxy implements InvocationHandler {

	private Object subject;

	/**
	 * @param subject
	 */
	public YiYuanProxy(Object subject) {
		super();
		this.subject = subject;
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] param) throws Throwable {
		Object object = method.invoke(subject, param);
		return object;
	}

}
