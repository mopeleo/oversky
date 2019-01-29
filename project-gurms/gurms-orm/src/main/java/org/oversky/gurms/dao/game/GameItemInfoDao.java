package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameItemInfo;
import java.util.List;

public interface GameItemInfoDao{

    int insert(GameItemInfo entity);

    List<GameItemInfo> selectAll(GameItemInfo where);

    GameItemInfo selectById(String itemid);

    int deleteById(String itemid);

    int updateById(GameItemInfo entity);
	
    int dynamicUpdateById(GameItemInfo entity);
}
