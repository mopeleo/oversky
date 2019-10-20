package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameLevelInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameLevelInfoDao{

	
    GameLevelInfo getById(Integer levelid);

    int deleteById(Integer levelid);

    int updateById(GameLevelInfo entity);
	
    int dynamicUpdateById(GameLevelInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameLevelInfo field, @Param("condition") GameLevelInfo where);
    
    int count(GameLevelInfo where);
    
	
    int insert(GameLevelInfo entity);

	
    int deleteWhere(GameLevelInfo where);

    List<GameLevelInfo> selectWhere(GameLevelInfo where);

	
    List<GameLevelInfo> selectAll();
    
	
	int updateBatch(List<GameLevelInfo> entityList);
	
	
	int deleteBatch(Integer[] ids);
	
	
	int insertBatch(List<GameLevelInfo> entityList);
	
}
