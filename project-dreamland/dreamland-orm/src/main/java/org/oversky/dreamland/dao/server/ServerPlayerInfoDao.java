package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerInfoDao{

	
    ServerPlayerInfo getById(String serverid, Long custno);

    int deleteById(String serverid, Long custno);

    int updateById(ServerPlayerInfo entity);
	
    int dynamicUpdateById(ServerPlayerInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerInfo field, @Param("condition") ServerPlayerInfo where);
    
    int count(ServerPlayerInfo where);
    
	
    int insert(ServerPlayerInfo entity);

	
    int deleteWhere(ServerPlayerInfo where);

    List<ServerPlayerInfo> selectWhere(ServerPlayerInfo where);

	
    List<ServerPlayerInfo> selectAll();
    
	
	int insertBatch(List<ServerPlayerInfo> entityList);
	
}
