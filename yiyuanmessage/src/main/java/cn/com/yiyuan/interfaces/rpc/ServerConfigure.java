/**
 * 
 */
package cn.com.yiyuan.interfaces.rpc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import cn.com.yiyuan.server.api.YySendMessageService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file ServerConfigure.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.interfaces.rpc.config
 * @summary java类
 * 
 */
@Configuration
public class ServerConfigure {
	
	@Resource(name = "YySendMessageService")
	private YySendMessageService yySendMessageService;
	@Value("${rpc.port}")
	private Integer rpcPort;
	
	@Bean
    public RmiServiceExporter serviceExporter()
    {
       RmiServiceExporter rse = new RmiServiceExporter();
       //rmi访问的名字是Hello
       rse.setServiceName("SendMessage");
       //rmi访问的端口号是1919
       rse.setRegistryPort(rpcPort);
       //rmi暴露给外部的访问接口是HelloInterface接口
       rse.setServiceInterface(YySendMessageService.class);
       //rmi实际使用的是Hello类的对象
       rse.setService(yySendMessageService);
       return rse;

    }
}
