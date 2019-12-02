package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GamePromotion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GamePromotionDao{

	
    GamePromotion getById(Long promid);

    int deleteById(Long promid);

    int updateById(GamePromotion entity);
	
    int dynamicUpdateById(GamePromotion entity);
    
	
    int dynamicUpdateWhere(@Param("field") GamePromotion field, @Param("condition") GamePromotion where);
    
    int count(GamePromotion where);
    
	
    int insert(GamePromotion entity);

	
    int deleteWhere(GamePromotion where);

    List<GamePromotion> selectWhere(GamePromotion where);

	
    List<GamePromotion> selectAll();
    
	
	int updateBatch(List<GamePromotion> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GamePromotion> entityList);
	
}
