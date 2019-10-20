package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameEquipInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameEquipInfoDao{

	
    GameEquipInfo getById(String equipid);

    int deleteById(String equipid);

    int updateById(GameEquipInfo entity);
	
    int dynamicUpdateById(GameEquipInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameEquipInfo field, @Param("condition") GameEquipInfo where);
    
    int count(GameEquipInfo where);
    
	
    int insert(GameEquipInfo entity);

	
    int deleteWhere(GameEquipInfo where);

    List<GameEquipInfo> selectWhere(GameEquipInfo where);

	
    List<GameEquipInfo> selectAll();
    
	
	int updateBatch(List<GameEquipInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameEquipInfo> entityList);
	
}
