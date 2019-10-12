package org.oversky.gurms.system.service;

import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.gurms.system.dto.request.SysDictReq;
import org.oversky.gurms.system.dto.response.SysDictRes;

public interface SysDictService {

	BaseResListDto<SysDictRes> getDictList(String unioncode, Integer dictcode);
	
	BaseResListDto<SysDictRes> getSpecialDict(Map<String, String> req);
	
	BaseResMapDto<String, List<SysDictRes>> getDictMap(String unioncode, String dictcodeList);
	
	BaseResListDto<SysDictRes> pageSysDict(SysDictReq dictReq);
}
