package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameMeunInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameMeunInfoDao{

	
    GameMeunInfo getById(String menuid);

    int deleteById(String menuid);

    int updateById(GameMeunInfo entity);
	
    int dynamicUpdateById(GameMeunInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameMeunInfo field, @Param("condition") GameMeunInfo where);
    
    int count(GameMeunInfo where);
    
	
    int insert(GameMeunInfo entity);

	
    int deleteWhere(GameMeunInfo where);

    List<GameMeunInfo> selectWhere(GameMeunInfo where);

	
    List<GameMeunInfo> selectAll();
    
	
	int updateBatch(List<GameMeunInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameMeunInfo> entityList);
	
}
