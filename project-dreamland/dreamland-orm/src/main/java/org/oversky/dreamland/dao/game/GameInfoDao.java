package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameInfoDao{

	
    GameInfo getById(Long gameid);

    int deleteById(Long gameid);

    int updateById(GameInfo entity);
	
    int dynamicUpdateById(GameInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameInfo field, @Param("condition") GameInfo where);
    
    int count(GameInfo where);
    
	
    int insert(GameInfo entity);

	
    int deleteWhere(GameInfo where);

    List<GameInfo> selectWhere(GameInfo where);

	
    List<GameInfo> selectAll();
    
	
	int updateBatch(List<GameInfo> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameInfo> entityList);
	
}
