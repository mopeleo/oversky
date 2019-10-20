package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GamePromotionInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GamePromotionInfoDao{

	
    GamePromotionInfo getById(Integer promid);

    int deleteById(Integer promid);

    int updateById(GamePromotionInfo entity);
	
    int dynamicUpdateById(GamePromotionInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GamePromotionInfo field, @Param("condition") GamePromotionInfo where);
    
    int count(GamePromotionInfo where);
    
	
    int insert(GamePromotionInfo entity);

	
    int deleteWhere(GamePromotionInfo where);

    List<GamePromotionInfo> selectWhere(GamePromotionInfo where);

	
    List<GamePromotionInfo> selectAll();
    
	
	int updateBatch(List<GamePromotionInfo> entityList);
	
	
	int deleteBatch(Integer[] ids);
	
	
	int insertBatch(List<GamePromotionInfo> entityList);
	
}
