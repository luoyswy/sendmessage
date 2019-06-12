/**
 * 
 */
package cn.com.yiyuan.application.email;

import java.util.Map;

import cn.com.yiyuan.application.SendMessageAbstract;
import cn.com.yiyuan.pojo.StatusResultEntity;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.pojo.YyMessageLogPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessageEmailAbstract.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.application.email.qq
 * @summary java类
 * 
 */
public abstract class SendMessageEmailAbstract extends SendMessageAbstract {

	@SuppressWarnings("rawtypes")
	@Override
	public abstract StatusResultEntity sendMessage(Map data) throws Exception;

	@SuppressWarnings("rawtypes")
	@Override
	protected abstract YyMessageLogPojo insertMessageToDatabase(Map data,YyMessageAccountPojo accountPojo) throws Exception;

	@SuppressWarnings("rawtypes")
	@Override
	protected abstract void updateMessageStatusToDatabase(Map data, YyMessageLogPojo logPojo) throws Exception;

}
