package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerActor;
import java.util.List;

public interface ServerPlayerActorDao{

    int insert(ServerPlayerActor entity);

    List<ServerPlayerActor> selectAll(ServerPlayerActor where);

    ServerPlayerActor selectById(String serverid, Long custno, String actorid);

    int deleteById(String serverid, Long custno, String actorid);

    int updateById(ServerPlayerActor entity);
	
    int dynamicUpdateById(ServerPlayerActor entity);
}
