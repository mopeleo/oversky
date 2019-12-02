package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSuit;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSuitDao{

	
    GameSuit getById(Long suitid);

    int deleteById(Long suitid);

    int updateById(GameSuit entity);
	
    int dynamicUpdateById(GameSuit entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameSuit field, @Param("condition") GameSuit where);
    
    int count(GameSuit where);
    
	
    int insert(GameSuit entity);

	
    int deleteWhere(GameSuit where);

    List<GameSuit> selectWhere(GameSuit where);

	
    List<GameSuit> selectAll();
    
	
	int updateBatch(List<GameSuit> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameSuit> entityList);
	
}
