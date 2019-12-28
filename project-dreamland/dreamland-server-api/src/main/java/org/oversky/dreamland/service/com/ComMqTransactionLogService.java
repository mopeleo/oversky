package org.oversky.dreamland.service.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComMqTransactionLogReq;
import org.oversky.dreamland.dto.response.com.ComMqTransactionLogRes;

public interface ComMqTransactionLogService{

	ComMqTransactionLogRes getById(Long logid);
	
	ComMqTransactionLogRes delete(ComMqTransactionLogReq req);

	ComMqTransactionLogRes insert(ComMqTransactionLogReq req);
	
	ComMqTransactionLogRes update(ComMqTransactionLogReq req);

	BaseResListDto<ComMqTransactionLogRes> pageComMqTransactionLog(ComMqTransactionLogReq req);
}
