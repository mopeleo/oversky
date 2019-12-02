package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayer;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerDao{

	
    ServerPlayer getById(String serverid, Long custno);

    int deleteById(String serverid, Long custno);

    int updateById(ServerPlayer entity);
	
    int dynamicUpdateById(ServerPlayer entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayer field, @Param("condition") ServerPlayer where);
    
    int count(ServerPlayer where);
    
	
    int insert(ServerPlayer entity);

	
    int deleteWhere(ServerPlayer where);

    List<ServerPlayer> selectWhere(ServerPlayer where);

	
    List<ServerPlayer> selectAll();
    
	
	int insertBatch(List<ServerPlayer> entityList);
	
}
