package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameItemInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameItemInfoDao{

	
    GameItemInfo getById(String itemid);

    int deleteById(String itemid);

    int updateById(GameItemInfo entity);
	
    int dynamicUpdateById(GameItemInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameItemInfo field, @Param("condition") GameItemInfo where);
    
    int count(GameItemInfo where);
    
	
    int insert(GameItemInfo entity);

	
    int deleteWhere(GameItemInfo where);

    List<GameItemInfo> selectWhere(GameItemInfo where);

	
    List<GameItemInfo> selectAll();
    
	
	int updateBatch(List<GameItemInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameItemInfo> entityList);
	
}
