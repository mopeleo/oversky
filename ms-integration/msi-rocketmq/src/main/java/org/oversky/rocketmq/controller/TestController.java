package org.oversky.rocketmq.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.oversky.rocketmq.config.RocketConfig;
import org.oversky.rocketmq.producer.CustInfoExtProducer;
import org.oversky.rocketmq.transaction.TransactionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
    private CustInfoExtProducer producer;

	@Autowired
    private TransactionProducer tp;

    @RequestMapping("/test/hello")
    public String hello(){		
        return "hello world";
    } 

    @RequestMapping("/test/rocketmq")
    public Object callback() throws Exception {
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
        
        return "成功";
    } 

    @RequestMapping("/test/timeout")
    public Object timeOut() throws Exception {
        //创建生产信息
        Message message = new Message(RocketConfig.TOPIC, "testtag", ("小小三岁了").getBytes());
      //设置重试次数(默认2次）
        producer.getProducer().setRetryTimesWhenSendFailed(5);
        //发送
        SendResult sendResult = producer.getProducer().send(message, 3);
        System.out.println("超时信息=" + sendResult);
        
        return "成功";
    } 

    @RequestMapping("/test/mq/{custno}")
    public Object mqTransaction(@PathVariable Long custno) {
        tp.execute(custno);        
        return "成功";
    } 
}
