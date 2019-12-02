package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSkill;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSkillDao{

	
    GameSkill getById(Long skillid);

    int deleteById(Long skillid);

    int updateById(GameSkill entity);
	
    int dynamicUpdateById(GameSkill entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameSkill field, @Param("condition") GameSkill where);
    
    int count(GameSkill where);
    
	
    int insert(GameSkill entity);

	
    int deleteWhere(GameSkill where);

    List<GameSkill> selectWhere(GameSkill where);

	
    List<GameSkill> selectAll();
    
	
	int updateBatch(List<GameSkill> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<GameSkill> entityList);
	
}
