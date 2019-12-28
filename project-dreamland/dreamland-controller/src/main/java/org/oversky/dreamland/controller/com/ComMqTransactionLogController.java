package org.oversky.dreamland.controller.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComMqTransactionLogReq;
import org.oversky.dreamland.dto.response.com.ComMqTransactionLogRes;
import org.oversky.dreamland.service.com.ComMqTransactionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commqtransactionlog")
public class ComMqTransactionLogController {
	@Autowired
	private ComMqTransactionLogService comMqTransactionLogService;

	@RequestMapping("/detail")
	public ComMqTransactionLogRes detail(Long logid) {
		return comMqTransactionLogService.getById(logid);
	}

	@RequestMapping("/delete")
	public ComMqTransactionLogRes delete(@RequestBody ComMqTransactionLogReq request) {
		return comMqTransactionLogService.delete(request);
	}

	@RequestMapping("/add")
	public ComMqTransactionLogRes add(@RequestBody ComMqTransactionLogReq request) {
		return comMqTransactionLogService.insert(request);
	}

	@RequestMapping("/update")
	public ComMqTransactionLogRes update(@RequestBody ComMqTransactionLogReq request) {
		return comMqTransactionLogService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ComMqTransactionLogRes> page(@RequestBody ComMqTransactionLogReq request) {
		return comMqTransactionLogService.pageComMqTransactionLog(request);
	}
}
