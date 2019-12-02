package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameAttribute;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameAttributeDao{

	
    GameAttribute getById(Long attrid);

    int deleteById(Long attrid);

    int updateById(GameAttribute entity);
	
    int dynamicUpdateById(GameAttribute entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameAttribute field, @Param("condition") GameAttribute where);
    
    int count(GameAttribute where);
    
	
    int insert(GameAttribute entity);

	
    int deleteWhere(GameAttribute where);

    List<GameAttribute> selectWhere(GameAttribute where);

	
    List<GameAttribute> selectAll();
    
	
	int updateBatch(List<GameAttribute> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameAttribute> entityList);
	
}
