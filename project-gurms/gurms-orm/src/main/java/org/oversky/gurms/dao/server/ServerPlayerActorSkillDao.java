package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerActorSkill;
import java.util.List;

public interface ServerPlayerActorSkillDao{

    int insert(ServerPlayerActorSkill entity);

    List<ServerPlayerActorSkill> selectAll(ServerPlayerActorSkill where);

    ServerPlayerActorSkill selectById(Long paid, String skillid);

    int deleteById(Long paid, String skillid);

    int updateById(ServerPlayerActorSkill entity);
	
    int dynamicUpdateById(ServerPlayerActorSkill entity);
}
