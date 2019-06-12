/**
 * 
 */
package cn.com.yiyuan.application;

import java.util.Map;

import cn.com.yiyuan.annoandenum.enums.MessageAccountEnum;
import cn.com.yiyuan.annoandenum.enums.ParamsFixaCon;
import cn.com.yiyuan.pojo.StatusResultEntity;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.pojo.YyMessageLogPojo;
import cn.com.yiyuan.server.api.YyMessageAccountService;
import cn.com.yiyuan.server.api.YyMessageLogService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessageAbstract.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.application
 * @summary java类
 * 
 */
public abstract class SendMessageAbstract implements SendMessageInterface {

	@SuppressWarnings("rawtypes")
	@Override
	public abstract StatusResultEntity sendMessage(Map data) throws Exception;
	
	@SuppressWarnings("rawtypes")
	protected abstract YyMessageLogPojo insertMessageToDatabase(Map data,YyMessageAccountPojo accountPojo) throws Exception;
	
	@SuppressWarnings("rawtypes")
	protected abstract void updateMessageStatusToDatabase(Map data,YyMessageLogPojo logPojo) throws Exception;
	
	@SuppressWarnings("rawtypes")
	protected YyMessageLogService getMessageLogService(Map data) throws Exception{
		Object object = data.get(ParamsFixaCon.LOGSERVICE.value());
		YyMessageLogService yyMessageLogService = null;
		if(object instanceof YyMessageLogService) {
			yyMessageLogService = (YyMessageLogService) object;
		}
		return yyMessageLogService;
	}
	
	@SuppressWarnings("rawtypes")
	protected YyMessageAccountService getMessageAccount(Map data) throws Exception{
		YyMessageAccountService yyMessageAccountService = null;
		Object object = data.get(ParamsFixaCon.ACCOUNTSERVICE.value());
		if(object instanceof YyMessageAccountService) {
			yyMessageAccountService = (YyMessageAccountService) object;
		}
		return yyMessageAccountService;
	}
	
	@SuppressWarnings("rawtypes")
	protected YyMessageAccountPojo getMessageAccountEntity(Map data) throws Exception{
		YyMessageAccountService yyMessageAccountService = getMessageAccount(data);
		if(yyMessageAccountService == null) return null;
		String tag = (String) data.get(MessageAccountEnum.TAG.value());
		String type = (String) data.get(MessageAccountEnum.TYPE.value());
		YyMessageAccountPojo yyMessageAccountPojo = yyMessageAccountService.selectMessageAccountByTag(tag, type);
		return yyMessageAccountPojo;
	}
	
}
