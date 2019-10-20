package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSuitEquip;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSuitEquipDao{

	
    GameSuitEquip getById(String suitid, String equipid);

    int deleteById(String suitid, String equipid);

    int count(GameSuitEquip where);
    
	
    int insert(GameSuitEquip entity);

	
    int deleteWhere(GameSuitEquip where);

    List<GameSuitEquip> selectWhere(GameSuitEquip where);

	
    List<GameSuitEquip> selectAll();
    
	
	int insertBatch(List<GameSuitEquip> entityList);
	
}
