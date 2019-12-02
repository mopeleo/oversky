package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameActor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameActorDao{

	
    GameActor getById(Long actorid);

    int deleteById(Long actorid);

    int updateById(GameActor entity);
	
    int dynamicUpdateById(GameActor entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameActor field, @Param("condition") GameActor where);
    
    int count(GameActor where);
    
	
    int insert(GameActor entity);

	
    int deleteWhere(GameActor where);

    List<GameActor> selectWhere(GameActor where);

	
    List<GameActor> selectAll();
    
	
	int updateBatch(List<GameActor> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameActor> entityList);
	
}
