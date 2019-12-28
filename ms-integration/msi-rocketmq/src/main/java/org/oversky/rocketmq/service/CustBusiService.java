package org.oversky.rocketmq.service;

import org.oversky.dreamland.entity.cust.CustInfoExt;

public interface CustBusiService {

	boolean doBusiness(CustInfoExt cust, String transactionId);
	
	boolean checkBusiness(String transactionId);
}
