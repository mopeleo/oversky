package org.oversky.dreamland.controller.com;

import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.dreamland.dto.response.com.ComDictRes;
import org.oversky.dreamland.service.com.ComDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comdict")
public class ComDictController {
	@Autowired
	private ComDictService dictService;

	@RequestMapping("/getlist/{dictcode}")
	public BaseResListDto<ComDictRes> getDictList(@PathVariable Integer dictcode) {
		return dictService.getDictList(dictcode);
	}
	
	@RequestMapping("/gettype")
	public BaseResListDto<ComDictRes> getDictList(@RequestBody Map<String, String> req) {
		return dictService.getSpecialDict(req);
	}
	
	@RequestMapping("/getmap")
	public BaseResMapDto<String, List<ComDictRes>> getDictMap(String dictcode) {
		return dictService.getDictMap(dictcode);
	}

}
