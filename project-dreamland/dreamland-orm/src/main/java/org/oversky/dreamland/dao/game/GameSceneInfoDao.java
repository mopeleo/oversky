package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSceneInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSceneInfoDao{

	
    GameSceneInfo getById(Long sceneid);

    int deleteById(Long sceneid);

    int updateById(GameSceneInfo entity);
	
    int dynamicUpdateById(GameSceneInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameSceneInfo field, @Param("condition") GameSceneInfo where);
    
    int count(GameSceneInfo where);
    
	
    int insert(GameSceneInfo entity);

	
    int deleteWhere(GameSceneInfo where);

    List<GameSceneInfo> selectWhere(GameSceneInfo where);

	
    List<GameSceneInfo> selectAll();
    
	
	int updateBatch(List<GameSceneInfo> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameSceneInfo> entityList);
	
}
