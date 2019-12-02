package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameItemDao{

	
    GameItem getById(Long itemid);

    int deleteById(Long itemid);

    int updateById(GameItem entity);
	
    int dynamicUpdateById(GameItem entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameItem field, @Param("condition") GameItem where);
    
    int count(GameItem where);
    
	
    int insert(GameItem entity);

	
    int deleteWhere(GameItem where);

    List<GameItem> selectWhere(GameItem where);

	
    List<GameItem> selectAll();
    
	
	int updateBatch(List<GameItem> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameItem> entityList);
	
}
