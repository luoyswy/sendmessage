/**
 * 
 */
package cn.com.yiyuan.interfaces.restfull;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yiyuan.server.api.YySendMessageService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file SendMessageController.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.interfaces.restfull
 * @summary java类
 * 
 */
@Controller
public class SendMessageController {

	@Resource(name = "YySendMessageService")
	private YySendMessageService yySendMessageService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/sendmessage")
	@ResponseBody
	public Object sendMessage(@RequestParam Map datas) {
		Object obj = null;
		try {
			obj = yySendMessageService.sendMessage(datas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	@RequestMapping("/testmessage")
	public String testSendMessage() {
		
		return "testsendmessage";
	}
	
}
