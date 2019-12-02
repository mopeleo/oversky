package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameScene;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSceneDao{

	
    GameScene getById(Long sceneid);

    int deleteById(Long sceneid);

    int updateById(GameScene entity);
	
    int dynamicUpdateById(GameScene entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameScene field, @Param("condition") GameScene where);
    
    int count(GameScene where);
    
	
    int insert(GameScene entity);

	
    int deleteWhere(GameScene where);

    List<GameScene> selectWhere(GameScene where);

	
    List<GameScene> selectAll();
    
	
	int updateBatch(List<GameScene> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameScene> entityList);
	
}
