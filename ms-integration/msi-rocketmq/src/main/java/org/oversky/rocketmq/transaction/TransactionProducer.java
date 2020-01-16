package org.oversky.rocketmq.transaction;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.rocketmq.config.RocketConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class TransactionProducer implements InitializingBean {

	private static TransactionMQProducer producer = new TransactionMQProducer(RocketConfig.PRODUCER_TX_GROUP);
	
	@Autowired
    private MQTransactionListener transactionListener;
	
	@Override
	public void afterPropertiesSet() throws Exception {
        producer.setNamesrvAddr(RocketConfig.NAME_SERVER);
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                System.out.println("threadPoolExecutor : " + System.currentTimeMillis() + " , threadName : " + thread.getName());
                return thread;
            }
        });

        producer.setExecutorService(executorService);
        //设置回调检查监听器
        producer.setTransactionListener(transactionListener);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
	}
	
	public void execute(Long custno) {
		try {
			CustInfoExt cust = new CustInfoExt();
			cust.setCustno(custno);
			cust.setSex("1");
			cust.setPostcode("56789");
            Message msg = new Message(RocketConfig.TOPIC, "tag", cust.buildEntityKey(), JSON.toJSONString(cust).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.println("prepare事务消息发送结果:"+sendResult.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
