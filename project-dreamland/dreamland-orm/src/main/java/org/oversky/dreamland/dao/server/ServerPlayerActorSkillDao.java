package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerActorSkill;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerActorSkillDao{

	
    ServerPlayerActorSkill getById(Long paid, String skillid);

    int deleteById(Long paid, String skillid);

    int updateById(ServerPlayerActorSkill entity);
	
    int dynamicUpdateById(ServerPlayerActorSkill entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerActorSkill field, @Param("condition") ServerPlayerActorSkill where);
    
    int count(ServerPlayerActorSkill where);
    
	
    int insert(ServerPlayerActorSkill entity);

	
    int deleteWhere(ServerPlayerActorSkill where);

    List<ServerPlayerActorSkill> selectWhere(ServerPlayerActorSkill where);

	
    List<ServerPlayerActorSkill> selectAll();
    
	
	int insertBatch(List<ServerPlayerActorSkill> entityList);
	
}
