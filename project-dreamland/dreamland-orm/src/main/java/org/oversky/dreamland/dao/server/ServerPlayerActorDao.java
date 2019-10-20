package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerActor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerActorDao{

	
    ServerPlayerActor getById(String serverid, Long custno, String actorid);

    int deleteById(String serverid, Long custno, String actorid);

    int updateById(ServerPlayerActor entity);
	
    int dynamicUpdateById(ServerPlayerActor entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerActor field, @Param("condition") ServerPlayerActor where);
    
    int count(ServerPlayerActor where);
    
	
    int insert(ServerPlayerActor entity);

	
    int deleteWhere(ServerPlayerActor where);

    List<ServerPlayerActor> selectWhere(ServerPlayerActor where);

	
    List<ServerPlayerActor> selectAll();
    
	
	int insertBatch(List<ServerPlayerActor> entityList);
	
}
