package org.oversky.dreamland.service.impl.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.dreamland.dao.com.ComDictDao;
import org.oversky.dreamland.dao.game.GameInfoDao;
import org.oversky.dreamland.dto.response.com.ComDictRes;
import org.oversky.dreamland.entity.com.ComDict;
import org.oversky.dreamland.entity.game.GameInfo;
import org.oversky.dreamland.service.com.ComDictService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@CacheConfig(cacheNames = "ComDict")
public class ComDictServiceImpl implements ComDictService {

	private static final Logger log = LoggerFactory.getLogger(ComDictServiceImpl.class);

	@Autowired
	private ComDictDao dictDao;
	
	@Autowired
	private GameInfoDao gameInfoDao;

	@Override
	@Cacheable(key = "'getDictList_' + #p0")
	public BaseResListDto<ComDictRes> getDictList(Integer dictcode) {
		log.info("查询单个字典 : dictcode = {}", dictcode);
		ComDict where = new ComDict();
		where.setDictcode(dictcode);
		List<ComDict> list = dictDao.selectWhere(where);
		List<ComDictRes> dictResList = BeanCopyUtils.convertList(list, ComDictRes.class);
		
		BaseResListDto<ComDictRes> resList = new BaseResListDto<>();
		resList.setResults(dictResList);
		resList.success("查询成功");
		return resList;
	}

	@Override
	@Cacheable(key = "'getDictMap_' + #p0")
	public BaseResMapDto<String, List<ComDictRes>> getDictMap(String dictcodeList) {
		log.info("查询多个字典 : dictcode = {}", dictcodeList);
		String[] codeList = dictcodeList.split(",");
		BaseResMapDto<String, List<ComDictRes>> dictMap = new BaseResMapDto<>();
		for(String dictcode : codeList) {
			List<ComDictRes> roleResList = getDictList(Integer.parseInt(dictcode)).getResults();
			dictMap.putMap(dictcode, roleResList);
		}
		
		dictMap.success("查询成功");
		return dictMap;
	}

	@Override
	public BaseResListDto<ComDictRes> getSpecialDict(Map<String, String> req) {
		String type = req.get("type");
		log.info("查询特殊字典 : type = {}", type);
		BaseResListDto<ComDictRes> resList = new BaseResListDto<>();
		List<ComDictRes> dictResList = null;
		switch(type) {
			case "T20":
				log.info("转换游戏[game_info]信息为字典");
				GameInfo where = new GameInfo();
				where.setUnioncode(req.get("unioncode"));
				List<GameInfo> gameList = gameInfoDao.selectWhere(where);
				if(CollectionUtils.isEmpty(gameList)) {
					break;
				}
				dictResList = new ArrayList<>(gameList.size());
				for(GameInfo game : gameList) {
					ComDictRes res = new ComDictRes();
					res.setItemcode(game.getGameid().toString());
					res.setItemname(game.getGamename());
					
					dictResList.add(res);
				}
				break;
			default:
				log.warn("错误的字典类型 : type = {}", type);
				break;
		}
		
		resList.setResults(dictResList);
		resList.success("查询成功");
		return resList;
	}

}
