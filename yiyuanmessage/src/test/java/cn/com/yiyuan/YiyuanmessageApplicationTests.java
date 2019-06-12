package cn.com.yiyuan;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.yiyuan.annoandenum.enums.ParamsFixaCon;
import cn.com.yiyuan.server.api.YySendMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YiyuanmessageApplicationTests {

	@Resource(name = "YySendMessageService")
	private YySendMessageService yySendMessageService;
	
	
	@Test
	public void contextLoads() {
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test() throws Exception {
		
	}

}
