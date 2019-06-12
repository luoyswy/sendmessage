/**
 * 
 */
package cn.com.yiyuan.interfaces.rabbitmq;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import cn.com.yiyuan.server.api.YySendMessageService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file ReceiveMessage.java
 * @date 2019年5月12日
 * @package cn.com.yiyuan.interfaces.rabbitmq
 * @summary rabbitmq的监听事件
 * 
 */
@Component
public class ReceiveMessage {
	
	@Resource(name = "YySendMessageService")
	private YySendMessageService yySendMessageService;
	
	@SuppressWarnings("rawtypes")
	@RabbitListener(queues="${rabbit.queue.sendmessage}")    //监听器监听指定的Queue
    public void processC(Map datas) {
		System.out.println(datas.toString());
		try {
			yySendMessageService.sendMessage(datas);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
