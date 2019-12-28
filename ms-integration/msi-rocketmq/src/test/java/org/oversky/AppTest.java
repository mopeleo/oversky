package org.oversky;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.rocketmq.service.RocketMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)  
@SpringBootTest(classes = App.class)
public class AppTest{

	@Autowired
	private RocketMQService busiService;
	
	@Test
	public void save() {
		try {
			busiService.sendMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
