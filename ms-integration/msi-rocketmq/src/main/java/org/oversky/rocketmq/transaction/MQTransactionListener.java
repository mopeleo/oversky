package org.oversky.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.rocketmq.service.CustBusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class MQTransactionListener implements TransactionListener {

	@Autowired
	private CustBusiService custService;
	
	@Override
	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		System.out.println("begin execute local tranaction......");
		LocalTransactionState state = LocalTransactionState.UNKNOW;
		CustInfoExt cust =  JSON.parseObject(msg.getBody(), CustInfoExt.class);	
		state = custService.doBusiness(cust, msg.getTransactionId()) ? LocalTransactionState.COMMIT_MESSAGE: LocalTransactionState.ROLLBACK_MESSAGE;

//		try {
//			CustInfoExt cust =  JSON.parseObject(msg.getBody(), CustInfoExt.class);	
//			state = custService.doBusiness(cust, msg.getTransactionId()) ? LocalTransactionState.COMMIT_MESSAGE: LocalTransactionState.ROLLBACK_MESSAGE;
//		}catch(Exception e) {
//			e.printStackTrace();
//			state = LocalTransactionState.ROLLBACK_MESSAGE;
//		}
		return state;
	}

	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		System.out.println("do check local tranaction......");
		// TODO Auto-generated method stub
		LocalTransactionState state = LocalTransactionState.UNKNOW;
		try {
			state = custService.checkBusiness(msg.getTransactionId()) ? LocalTransactionState.COMMIT_MESSAGE: LocalTransactionState.ROLLBACK_MESSAGE;
		}catch(Exception e) {
			e.printStackTrace();
			state = LocalTransactionState.ROLLBACK_MESSAGE;
		}
		return state;
	}

}
