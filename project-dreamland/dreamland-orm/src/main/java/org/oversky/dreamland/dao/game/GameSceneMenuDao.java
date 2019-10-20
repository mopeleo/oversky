package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSceneMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSceneMenuDao{

	
    GameSceneMenu getById(Integer sceneid, String menuid);

    int deleteById(Integer sceneid, String menuid);

    int count(GameSceneMenu where);
    
	
    int insert(GameSceneMenu entity);

	
    int deleteWhere(GameSceneMenu where);

    List<GameSceneMenu> selectWhere(GameSceneMenu where);

	
    List<GameSceneMenu> selectAll();
    
	
	int insertBatch(List<GameSceneMenu> entityList);
	
}
