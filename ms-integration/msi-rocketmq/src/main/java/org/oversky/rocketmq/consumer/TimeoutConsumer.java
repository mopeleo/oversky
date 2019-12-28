package org.oversky.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.oversky.rocketmq.config.RocketConfig;
import org.springframework.stereotype.Component;

//@Component
public class TimeoutConsumer {
	
	private DefaultMQPushConsumer consumer;

    public TimeoutConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(RocketConfig.CONSUMER_GROUP);
        consumer.setNamesrvAddr(RocketConfig.NAME_SERVER);
        //订阅topic和 tags（ * 代表所有标签)下信息
        consumer.subscribe(RocketConfig.TOPIC, "*");
        //注册消费的监听 并在此监听中消费信息，并返回消费的状态信息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            //1、获取消息
            Message msg = msgs.get(0);
            try {
                //2、消费者获取消息
                String body = new String(msg.getBody(), "utf-8");
                //3、获取重试次数
                int count = ((MessageExt) msg).getReconsumeTimes();
                System.out.println("当前消费重试次数为 = "+count);
                //4、这里设置重试大于3次 那么通过保存数据库 人工来兜底
                if (count >= 2) {
                	System.out.println("该消息已经重试3次,保存数据库。topic={"+msg.getTopic()+"},keys={"+msg.getKeys()+"},msg="+ body);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //直接抛出异常，没有消费掉，会重新执行
                throw new Exception("=======这里出错了============");
                //return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        //启动监听
        consumer.start();
    }
}
