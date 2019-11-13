package org.oversky.dreamland.service.com;

import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.dreamland.dto.response.com.ComDictRes;

public interface ComDictService {
	
	BaseResListDto<ComDictRes> getSpecialDict(Map<String, String> req);
	
	BaseResListDto<ComDictRes> getDictList(Integer dictcode);
	
	BaseResMapDto<String, List<ComDictRes>> getDictMap(String dictcodeList);

}
