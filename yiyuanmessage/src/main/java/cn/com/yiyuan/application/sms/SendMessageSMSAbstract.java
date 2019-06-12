/**
 * 
 */
package cn.com.yiyuan.application.sms;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;

import biz.source_code.base64Coder.Base64Coder;
import cn.com.yiyuan.application.SendMessageAbstract;
import cn.com.yiyuan.pojo.StatusResultEntity;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.pojo.YyMessageLogPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessageSMSAbstract.java
 * @date 2019年5月11日
 * @package cn.com.yiyuan.application.sms
 * @summary java类
 * 
 */
public abstract class SendMessageSMSAbstract extends SendMessageAbstract {

	@SuppressWarnings("rawtypes")
	@Override
	public abstract StatusResultEntity sendMessage(Map data) throws Exception ;

	@SuppressWarnings("rawtypes")
	@Override
	protected abstract YyMessageLogPojo insertMessageToDatabase(Map data,YyMessageAccountPojo accountPojo) throws Exception;
	
	@SuppressWarnings("rawtypes")
	@Override
	protected abstract void updateMessageStatusToDatabase(Map data, YyMessageLogPojo logPojo) throws Exception;

	protected String getMessage(String content, String phone,YyMessageAccountPojo accountPojo)
	  {
	    JSONObject jsonMessage = new JSONObject();
	    jsonMessage.put("ecName", accountPojo.getOrgaccount());
	    jsonMessage.put("apId", accountPojo.getAccount());
	    jsonMessage.put("secretKey", accountPojo.getPassword());
	    jsonMessage.put("mobiles", phone);
	    jsonMessage.put("content", content);
	    jsonMessage.put("sign", accountPojo.getSign());
	    jsonMessage.put("addSerial", accountPojo.getAddserival()==null?"":accountPojo.getAddserival());
	    String mac = getMac(jsonMessage);
	    jsonMessage.put("Mac", mac);
	    System.out.println("TWL-短信报文:" + jsonMessage.toJSONString());
	    System.out.println("TWL-开始base64编码");
	    
	    //String base64Message = Base64Util.encode(jsonMessage.toJSONString());
	    String base64Message = Base64Coder.encodeString(jsonMessage.toJSONString());
	    System.out.println("TWL-base64编码结束");
	    return base64Message;
	  }

	protected String getMac(JSONObject jsonMessage) {
	    StringBuffer macStrBuff = new StringBuffer();
	    macStrBuff.append(jsonMessage.get("ecName"));
	    macStrBuff.append(jsonMessage.get("apId"));
	    macStrBuff.append(jsonMessage.get("secretKey"));
	    macStrBuff.append(jsonMessage.get("mobiles"));
	    macStrBuff.append(jsonMessage.get("content"));
	    macStrBuff.append(jsonMessage.get("sign"));
	    macStrBuff.append(jsonMessage.get("addSerial"));
	    String macMd5Str = DigestUtils.md5Hex(macStrBuff.toString());
	    return macMd5Str;
	  }
}
