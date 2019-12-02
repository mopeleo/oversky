package org.oversky.dreamland.service.game.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dao.game.GameInfoDao;
import org.oversky.dreamland.dto.request.game.GameInfoReq;
import org.oversky.dreamland.dto.response.game.GameInfoRes;
import org.oversky.dreamland.entity.game.GameInfo;
import org.oversky.dreamland.ext.dao.PageListQueryDao;
import org.oversky.dreamland.ext.dao.UniqueCheckDao;
import org.oversky.dreamland.service.game.GameInfoService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class GameInfoServiceImpl implements GameInfoService {
    private static Logger log = LoggerFactory.getLogger(GameInfoServiceImpl.class);

    @Autowired
    private GameInfoDao gameInfoDao;
	@Autowired
	private PageListQueryDao pageQueryDao;
	@Autowired
	private UniqueCheckDao uniqueCheckDao;

	@Override
	public GameInfoRes getById(Long gameid) {
		log.info("开始查询游戏信息[gameid={}]信息...", gameid);
		GameInfoRes res = new GameInfoRes();
		GameInfo gameInfo = gameInfoDao.getById(gameid);
		if(gameInfo == null) {
			res.failure("游戏信息不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		BeanCopyUtils.copy(gameInfo, res);
		res.success();
		log.info("查询游戏信息[gameid={}]结束: {}", gameid, res.getReturnmsg());
		return res;
	}

	@Override
	public GameInfoRes delete(GameInfoReq gameReq) {
		log.info("开始删除游戏[gameid={}]", gameReq.getGameid());
		GameInfoRes res = new GameInfoRes();
		gameInfoDao.deleteById(gameReq.getGameid());
		res.success();
		log.info("删除游戏[gameid={}]结束 : {}", gameReq.getGameid(), res.getReturnmsg());
		return res;
	}

	@Override
	public GameInfoRes insert(GameInfoReq gameReq) {
		log.info("开始新增游戏......");
		GameInfoRes res = new GameInfoRes();
		if(!this.check(gameReq, res)) {
			return res;
		}
		
		GameInfo game = BeanCopyUtils.convert(gameReq, GameInfo.class);
		gameInfoDao.insert(game);
		res.success("新增游戏成功");
		
		log.info("新增游戏结束 : {}", res.getReturnmsg());
		return res;
	}

	@Override
	public GameInfoRes update(GameInfoReq gameReq) {
		log.info("开始修改游戏[gameid={}]信息......", gameReq.getGameid());
		GameInfoRes res = new GameInfoRes();
		if(!this.check(gameReq, res)) {
			return res;
		}
		
		GameInfo cust = BeanCopyUtils.convert(gameReq, GameInfo.class);
		gameInfoDao.dynamicUpdateById(cust);

		res.success("修改成功");
		log.info("修改游戏[gameid={}]结束: {}", gameReq.getGameid(), res.getReturnmsg());
		return res;
	}

	@Override
	public BaseResListDto<GameInfoRes> pageGameInfo(GameInfoReq gameReq) {
		log.info("开始分页查询游戏信息，req : {}", gameReq.toString());
		Page<GameInfoRes> page = PageHelper.startPage(gameReq.getPageNum(), gameReq.getPageSize());
		GameInfo where = BeanCopyUtils.convert(gameReq, GameInfo.class);
		List<GameInfo> gameList = pageQueryDao.findGameList(where);
		List<GameInfoRes> custResList = BeanCopyUtils.convertList(gameList, GameInfoRes.class);
		
		BaseResListDto<GameInfoRes> resList = new BaseResListDto<GameInfoRes>();
		resList.setResults(custResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询游戏信息结束，共查询到{}条", gameList.size());
		return resList;
	}
	
	private boolean check(GameInfoReq gameReq, GameInfoRes res) {
		if(StringUtils.isEmpty(gameReq.getGamecode())) {
			res.failure("游戏编号不能为空");
			log.warn(res.getReturnmsg());
			return false;
		}
		
		return true;
	}

}
