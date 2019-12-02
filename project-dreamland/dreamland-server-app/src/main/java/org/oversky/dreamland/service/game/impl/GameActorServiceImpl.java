package org.oversky.dreamland.service.game.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dao.game.GameActorDao;
import org.oversky.dreamland.dto.request.game.GameActorReq;
import org.oversky.dreamland.dto.response.game.GameActorRes;
import org.oversky.dreamland.entity.game.GameActor;
import org.oversky.dreamland.ext.dao.PageListQueryDao;
import org.oversky.dreamland.service.game.GameActorService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class GameActorServiceImpl implements GameActorService {
    private static Logger log = LoggerFactory.getLogger(GameActorServiceImpl.class);

    @Autowired
    private GameActorDao gameActorDao;
	@Autowired
	private PageListQueryDao pageQueryDao;

	@Override
	public GameActorRes getById(Long actorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameActorRes delete(GameActorReq gameActorReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameActorRes insert(GameActorReq gameActorReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameActorRes update(GameActorReq gameActorReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResListDto<GameActorRes> pageGameActor(GameActorReq gameActorReq) {
		log.info("开始分页查询游戏角色，req : {}", gameActorReq.toString());
		Page<GameActorRes> page = PageHelper.startPage(gameActorReq.getPageNum(), gameActorReq.getPageSize());
		GameActor where = BeanCopyUtils.convert(gameActorReq, GameActor.class);
		List<GameActor> actorList = pageQueryDao.findGameActorList(where);
		List<GameActorRes> actorResList = BeanCopyUtils.convertList(actorList, GameActorRes.class);
		
		BaseResListDto<GameActorRes> resList = new BaseResListDto<GameActorRes>();
		resList.setResults(actorResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询游戏角色结束，共查询到{}条", actorList.size());
		return resList;
	}

}
