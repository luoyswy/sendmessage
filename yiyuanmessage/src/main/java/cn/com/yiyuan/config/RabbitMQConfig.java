/**
 * 
 */
package cn.com.yiyuan.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file RabbitMQConfig.java
 * @date 2019年5月12日
 * @package cn.com.yiyuan.config
 * @summary RabbitMQ的消息队列的配置
 * 
 */
@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbit.queue.sendmessage}")
	public String rabbitQueueSendMessage;
	@Value("${rabbit.exchange.directinform}")
    public String EXCHANGE_DIRECT_INFORM;
    
    @Bean("exchange_direct")
    public Exchange EXCHANGE_DIRECT_INFORM() {
    	//durable(true)持久化，消息队列重启后交换机仍然存在
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT_INFORM).durable(true).build();
    }
    
    //声明队列
    @Bean("queue_send_message")
    public Queue QUEUE_INFORM_SMS() {
        Queue queue = new Queue(rabbitQueueSendMessage);
        return queue;
    }
    
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier("queue_send_message") Queue queue, @Qualifier("exchange_direct") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitQueueSendMessage).noargs();
    }
}
