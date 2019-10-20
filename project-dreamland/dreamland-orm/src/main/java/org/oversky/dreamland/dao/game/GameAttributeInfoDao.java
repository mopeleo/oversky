package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameAttributeInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameAttributeInfoDao{

	
    GameAttributeInfo getById(Long attrid);

    int deleteById(Long attrid);

    int updateById(GameAttributeInfo entity);
	
    int dynamicUpdateById(GameAttributeInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameAttributeInfo field, @Param("condition") GameAttributeInfo where);
    
    int count(GameAttributeInfo where);
    
	
    int insert(GameAttributeInfo entity);

	
    int deleteWhere(GameAttributeInfo where);

    List<GameAttributeInfo> selectWhere(GameAttributeInfo where);

	
    List<GameAttributeInfo> selectAll();
    
	
	int updateBatch(List<GameAttributeInfo> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameAttributeInfo> entityList);
	
}
