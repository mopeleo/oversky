package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameActorSkill;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameActorSkillDao{

	
    GameActorSkill getById(Long actorid, Long skillid);

    int deleteById(Long actorid, Long skillid);

    int updateById(GameActorSkill entity);
	
    int dynamicUpdateById(GameActorSkill entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameActorSkill field, @Param("condition") GameActorSkill where);
    
    int count(GameActorSkill where);
    
	
    int insert(GameActorSkill entity);

	
    int deleteWhere(GameActorSkill where);

    List<GameActorSkill> selectWhere(GameActorSkill where);

	
    List<GameActorSkill> selectAll();
    
	
	int insertBatch(List<GameActorSkill> entityList);
	
}
