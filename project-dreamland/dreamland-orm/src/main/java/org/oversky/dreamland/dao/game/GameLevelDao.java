package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameLevel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameLevelDao{

	
    GameLevel getById(Long levelid);

    int deleteById(Long levelid);

    int updateById(GameLevel entity);
	
    int dynamicUpdateById(GameLevel entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameLevel field, @Param("condition") GameLevel where);
    
    int count(GameLevel where);
    
	
    int insert(GameLevel entity);

	
    int deleteWhere(GameLevel where);

    List<GameLevel> selectWhere(GameLevel where);

	
    List<GameLevel> selectAll();
    
	
	int updateBatch(List<GameLevel> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameLevel> entityList);
	
}
