package org.oversky.dreamland.service.impl.game;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dao.game.GameEquipDao;
import org.oversky.dreamland.dto.request.game.GameEquipReq;
import org.oversky.dreamland.dto.response.game.GameEquipRes;
import org.oversky.dreamland.entity.game.GameEquip;
import org.oversky.dreamland.ext.dao.DreamLandPageQueryDao;
import org.oversky.dreamland.service.game.GameEquipService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class GameEquipServiceImpl implements GameEquipService {
    private static Logger log = LoggerFactory.getLogger(GameEquipServiceImpl.class);

	@Autowired
	private GameEquipDao gameEquipDao;
	@Autowired
	private DreamLandPageQueryDao pageQueryDao;
	
	@Override
	public GameEquipRes getById(Long equipid) {
		GameEquipRes res = new GameEquipRes();
		GameEquip entity = gameEquipDao.getById(equipid);
		BeanCopyUtils.copy(entity, res);
		res.success();
		return res;
	}

	@Override
	public GameEquipRes delete(GameEquipReq gameEquipReq) {
		GameEquipRes res = new GameEquipRes();
		gameEquipDao.deleteById(gameEquipReq.getEquipid());
		res.success();
		return res;
	}

	@Override
	public GameEquipRes insert(GameEquipReq gameEquipReq) {
		log.info("开始新增......");
		GameEquipRes res = new GameEquipRes();
		GameEquip entity = BeanCopyUtils.convert(gameEquipReq, GameEquip.class);
		gameEquipDao.insert(entity);
		res.success();
		return res;
	}

	@Override
	public GameEquipRes update(GameEquipReq gameEquipReq) {
		GameEquipRes res = new GameEquipRes();
		GameEquip entity = BeanCopyUtils.convert(gameEquipReq, GameEquip.class);
		gameEquipDao.updateById(entity);
		res.success();
		return res;
	}

	@Override
	public BaseResListDto<GameEquipRes> pageGameEquip(GameEquipReq gameEquipReq) {
		log.info("开始分页查询，req : {}", gameEquipReq.toString());
		Page<GameEquipRes> page = PageHelper.startPage(gameEquipReq.getPageNum(), gameEquipReq.getPageSize());
		GameEquip where = BeanCopyUtils.convert(gameEquipReq, GameEquip.class);
		List<GameEquip> entityList = pageQueryDao.findGameEquipList(where);
		List<GameEquipRes> resList = BeanCopyUtils.convertList(entityList, GameEquipRes.class);
		
		BaseResListDto<GameEquipRes> resListDto = new BaseResListDto<GameEquipRes>();
		resListDto.setResults(resList);
		resListDto.success("查询成功");
		resListDto.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询结束，共查询到{}条", resList.size());
		return resListDto;
	}
}
