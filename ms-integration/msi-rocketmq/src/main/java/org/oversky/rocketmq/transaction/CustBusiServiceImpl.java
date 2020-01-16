package org.oversky.rocketmq.transaction;

import org.oversky.dreamland.dao.com.ComMqTransactionLogDao;
import org.oversky.dreamland.dao.cust.CustInfoExtDao;
import org.oversky.dreamland.entity.com.ComMqTransactionLog;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.rocketmq.service.CustBusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustBusiServiceImpl implements CustBusiService{

	@Autowired
	private CustInfoExtDao custDao;
	
	@Autowired
	private ComMqTransactionLogDao mqLogDao;
	
	@Transactional
	public boolean doBusiness(CustInfoExt cust, String transactionId) {
		custDao.insert(cust);
		
		ComMqTransactionLog log = new ComMqTransactionLog();
		log.setBusiId(String.valueOf(cust.getCustno()));
		log.setBusiType("0");
		log.setTransactionId(transactionId);
		mqLogDao.insert(log);
		
		System.out.println("CustBusiServiceImpl doBusiness success ......");
		return true;
	}
	
	public boolean checkBusiness(String transactionId) {
		System.out.println("CustBusiServiceImpl checkBusiness begin ......" + transactionId);
		ComMqTransactionLog where  = new ComMqTransactionLog();
		where.setTransactionId(transactionId);
		int cnt = mqLogDao.count(where);
		System.out.println("cnt ===> " + cnt);
		return cnt > 0;
	}
}
