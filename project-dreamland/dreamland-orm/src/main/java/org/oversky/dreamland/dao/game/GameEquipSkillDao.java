package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameEquipSkill;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameEquipSkillDao{

	
    GameEquipSkill getById(String equipid, String skillid);

    int deleteById(String equipid, String skillid);

    int updateById(GameEquipSkill entity);
	
    int dynamicUpdateById(GameEquipSkill entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameEquipSkill field, @Param("condition") GameEquipSkill where);
    
    int count(GameEquipSkill where);
    
	
    int insert(GameEquipSkill entity);

	
    int deleteWhere(GameEquipSkill where);

    List<GameEquipSkill> selectWhere(GameEquipSkill where);

	
    List<GameEquipSkill> selectAll();
    
	
	int insertBatch(List<GameEquipSkill> entityList);
	
}
