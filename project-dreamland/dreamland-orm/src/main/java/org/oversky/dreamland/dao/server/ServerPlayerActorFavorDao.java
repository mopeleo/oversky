package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerActorFavor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerActorFavorDao{

	
    ServerPlayerActorFavor getById(String serverid, String maleid, String femaleid);

    int deleteById(String serverid, String maleid, String femaleid);

    int updateById(ServerPlayerActorFavor entity);
	
    int dynamicUpdateById(ServerPlayerActorFavor entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerActorFavor field, @Param("condition") ServerPlayerActorFavor where);
    
    int count(ServerPlayerActorFavor where);
    
	
    int insert(ServerPlayerActorFavor entity);

	
    int deleteWhere(ServerPlayerActorFavor where);

    List<ServerPlayerActorFavor> selectWhere(ServerPlayerActorFavor where);

	
    List<ServerPlayerActorFavor> selectAll();
    
	
	int insertBatch(List<ServerPlayerActorFavor> entityList);
	
}
