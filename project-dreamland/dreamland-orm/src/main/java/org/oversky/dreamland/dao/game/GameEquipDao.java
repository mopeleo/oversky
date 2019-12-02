package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameEquip;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameEquipDao{

	
    GameEquip getById(Long equipid);

    int deleteById(Long equipid);

    int updateById(GameEquip entity);
	
    int dynamicUpdateById(GameEquip entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameEquip field, @Param("condition") GameEquip where);
    
    int count(GameEquip where);
    
	
    int insert(GameEquip entity);

	
    int deleteWhere(GameEquip where);

    List<GameEquip> selectWhere(GameEquip where);

	
    List<GameEquip> selectAll();
    
	
	int updateBatch(List<GameEquip> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameEquip> entityList);
	
}
