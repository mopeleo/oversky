package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSuitInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSuitInfoDao{

	
    GameSuitInfo getById(String suitid);

    int deleteById(String suitid);

    int updateById(GameSuitInfo entity);
	
    int dynamicUpdateById(GameSuitInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameSuitInfo field, @Param("condition") GameSuitInfo where);
    
    int count(GameSuitInfo where);
    
	
    int insert(GameSuitInfo entity);

	
    int deleteWhere(GameSuitInfo where);

    List<GameSuitInfo> selectWhere(GameSuitInfo where);

	
    List<GameSuitInfo> selectAll();
    
	
	int updateBatch(List<GameSuitInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameSuitInfo> entityList);
	
}
