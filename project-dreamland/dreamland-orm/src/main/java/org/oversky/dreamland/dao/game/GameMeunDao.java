package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameMeun;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameMeunDao{

	
    GameMeun getById(Long menuid);

    int deleteById(Long menuid);

    int updateById(GameMeun entity);
	
    int dynamicUpdateById(GameMeun entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameMeun field, @Param("condition") GameMeun where);
    
    int count(GameMeun where);
    
	
    int insert(GameMeun entity);

	
    int deleteWhere(GameMeun where);

    List<GameMeun> selectWhere(GameMeun where);

	
    List<GameMeun> selectAll();
    
	
	int updateBatch(List<GameMeun> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameMeun> entityList);
	
}
