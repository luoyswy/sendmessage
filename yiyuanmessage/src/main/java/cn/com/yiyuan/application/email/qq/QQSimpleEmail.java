/**
 * 
 */
package cn.com.yiyuan.application.email.qq;

import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.com.yiyuan.annoandenum.anno.TagSendMessageAnno;
import cn.com.yiyuan.annoandenum.enums.MessageAccountEnum;
import cn.com.yiyuan.annoandenum.enums.MessageLogEnum;
import cn.com.yiyuan.application.email.EmailAuthentication;
import cn.com.yiyuan.application.email.SendMessageEmailAbstract;
import cn.com.yiyuan.pojo.StatusResultEntity;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.pojo.YyMessageLogPojo;
import cn.com.yiyuan.server.api.YyMessageLogService;
import cn.com.yiyuan.util.common.DateUtil;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file QQSimpleEmail.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.application.email
 * @summary qq邮箱的简单类型的发送信息
 * 
 */
@TagSendMessageAnno(tag = "qqSimple")
public class QQSimpleEmail extends SendMessageEmailAbstract {

	@SuppressWarnings("rawtypes")
	@Override
	public StatusResultEntity sendMessage(Map data) throws Exception {
		String receiveAccount = (String) data.get("receiveAccount");
		String content = (String) data.get("content");
		String subject = (String) data.get("subject");
		YyMessageAccountPojo accountPojo = getMessageAccountEntity(data);
		if(accountPojo == null) return null;
		YyMessageLogPojo logPojo = insertMessageToDatabase(data, accountPojo);
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", accountPojo.getAttribute4());
		props.setProperty("mail.smtp.port", accountPojo.getAttribute5());
		props.put("mail.smtp.auth", "true");
		Session mailConnection = Session.getInstance(props, new EmailAuthentication(accountPojo.getAccount(), accountPojo.getPassword()));
		final Message message = new MimeMessage(mailConnection);
		Address to = new InternetAddress(receiveAccount);
		Address from = new InternetAddress(accountPojo.getAccount());
		message.setContent(content,"text/plain;charset=UTF-8");
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		message.setSubject(subject);
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Transport.send(message);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread thr = new Thread(r);
		thr.start();
		thr.join();
		updateMessageStatusToDatabase(data, logPojo);
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected YyMessageLogPojo insertMessageToDatabase(Map data,YyMessageAccountPojo accountPojo) throws Exception {
		// TODO Auto-generated method stub
		YyMessageLogService yyMessageLogService = getMessageLogService(data);
		if(yyMessageLogService == null) return null;
		YyMessageLogPojo logPojo = new YyMessageLogPojo();
		String receiveAccount = (String) data.get("receiveAccount");
		String content = (String) data.get("content");
		String tag = (String) data.get(MessageAccountEnum.TAG.value());
		String type = (String) data.get(MessageAccountEnum.TYPE.value());
		logPojo.setTag(tag);
		logPojo.setAttribute1(type);
		logPojo.setContent(content);
		logPojo.setDestination(receiveAccount);
		logPojo.setStatus(MessageLogEnum.FAILD.value());
		logPojo.setAttribute2(accountPojo.getAccount());
		logPojo.setAttribute3(DateUtil.getCurrentDate(""));
		return yyMessageLogService.insertMessageLog(logPojo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void updateMessageStatusToDatabase(Map data,YyMessageLogPojo logPojo) throws Exception {
		// TODO Auto-generated method stub
		YyMessageLogService yyMessageLogService = getMessageLogService(data);
		if(yyMessageLogService == null) return;
		logPojo.setStatus(MessageLogEnum.SUCCESS.value());
		yyMessageLogService.updateMessageLogStatusByid(logPojo);
	}

}
