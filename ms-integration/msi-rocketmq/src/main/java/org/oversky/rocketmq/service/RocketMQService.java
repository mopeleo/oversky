package org.oversky.rocketmq.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.oversky.rocketmq.config.RocketConfig;
import org.oversky.rocketmq.producer.CustInfoExtProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketMQService {

	@Autowired
    private CustInfoExtProducer producer;
	
	public void sendMsg() throws Exception {
		List<String> mesList = new ArrayList<>();
        mesList.add("小小");
        mesList.add("爸爸");
        mesList.add("妈妈");
        mesList.add("爷爷");
        mesList.add("奶奶");
		//总共发送五次消息
        for (String s : mesList) {
            //创建生产信息
            Message message = new Message(RocketConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
            //发送
            SendResult sendResult = producer.getProducer().send(message);
            System.out.println("输出生产者信息=" + sendResult);
        }
	}
}
