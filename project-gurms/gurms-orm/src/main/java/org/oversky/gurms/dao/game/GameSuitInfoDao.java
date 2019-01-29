package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameSuitInfo;
import java.util.List;

public interface GameSuitInfoDao{

    int insert(GameSuitInfo entity);

    List<GameSuitInfo> selectAll(GameSuitInfo where);

    GameSuitInfo selectById(String suitid);

    int deleteById(String suitid);

    int updateById(GameSuitInfo entity);
	
    int dynamicUpdateById(GameSuitInfo entity);
}
