package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameAttributeInfo;
import java.util.List;

public interface GameAttributeInfoDao{

    int insert(GameAttributeInfo entity);

    List<GameAttributeInfo> selectAll(GameAttributeInfo where);

    GameAttributeInfo selectById(Long attrid);

    int deleteById(Long attrid);

    int updateById(GameAttributeInfo entity);
	
    int dynamicUpdateById(GameAttributeInfo entity);
}
