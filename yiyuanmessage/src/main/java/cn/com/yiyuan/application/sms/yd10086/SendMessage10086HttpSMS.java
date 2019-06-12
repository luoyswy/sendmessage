/**
 * 
 */
package cn.com.yiyuan.application.sms.yd10086;

import java.util.Map;

import cn.com.yiyuan.application.sms.HttpRequest;
import cn.com.yiyuan.application.sms.SendMessageSMSAbstract;
import cn.com.yiyuan.pojo.StatusResultEntity;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.pojo.YyMessageLogPojo;
import cn.com.yiyuan.server.api.YyMessageLogService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessage10086HttpSMS.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.application.sms.yd10086
 * @summary 10086 http协议发送短信
 * 
 */
public class SendMessage10086HttpSMS extends SendMessageSMSAbstract {

	@SuppressWarnings("rawtypes")
	@Override
	public StatusResultEntity sendMessage(Map data) throws Exception {
		String receiveAccount = (String) data.get("receiveAccount");
		String content = (String) data.get("content");
		YyMessageAccountPojo accountPojo = getMessageAccountEntity(data);
		content = getMessage(content, receiveAccount, accountPojo);
		String result = HttpRequest.sendPost(accountPojo.getAttribute4(), content);
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected YyMessageLogPojo insertMessageToDatabase(Map data,YyMessageAccountPojo accountPojo) throws Exception {
		// TODO Auto-generated method stub
		YyMessageLogService yyMessageLogService = getMessageLogService(data);
		if(yyMessageLogService == null) return null;
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void updateMessageStatusToDatabase(Map data, YyMessageLogPojo logPojo) throws Exception {
		// TODO Auto-generated method stub
		YyMessageLogService yyMessageLogService = getMessageLogService(data);
		if(yyMessageLogService == null) return;
		yyMessageLogService.updateMessageLogStatusByid(logPojo);
	}

}
