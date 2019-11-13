package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSuitEquip;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSuitEquipDao{

	
    GameSuitEquip getById(Long suitid, Long equipid);

    int deleteById(Long suitid, Long equipid);

    int count(GameSuitEquip where);
    
	
    int insert(GameSuitEquip entity);

	
    int deleteWhere(GameSuitEquip where);

    List<GameSuitEquip> selectWhere(GameSuitEquip where);

	
    List<GameSuitEquip> selectAll();
    
	
	int insertBatch(List<GameSuitEquip> entityList);
	
}
