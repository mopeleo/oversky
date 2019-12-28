package org.oversky.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.oversky.rocketmq.config.RocketConfig;
import org.springframework.stereotype.Component;

@Component
public class CustInfoExtProducer {
	
    private DefaultMQProducer producer;
    
    public CustInfoExtProducer(){
        //示例生产者
        producer = new DefaultMQProducer(RocketConfig.PRODUCER_GROUP);
        //不开启vip通道 开通口端口会减2
        producer.setVipChannelEnabled(false);
        //绑定name server
        producer.setNamesrvAddr(RocketConfig.NAME_SERVER);
//        producer.setCreateTopicKey(RocketConfig.TOPIC);
        start();
    }
    
    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
  
    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    
    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }
}
