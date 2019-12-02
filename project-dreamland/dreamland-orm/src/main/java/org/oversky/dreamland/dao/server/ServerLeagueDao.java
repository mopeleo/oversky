package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerLeague;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerLeagueDao{

	
    ServerLeague getById(Long leagueid);

    int deleteById(Long leagueid);

    int updateById(ServerLeague entity);
	
    int dynamicUpdateById(ServerLeague entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerLeague field, @Param("condition") ServerLeague where);
    
    int count(ServerLeague where);
    
	
    int insert(ServerLeague entity);

	
    int deleteWhere(ServerLeague where);

    List<ServerLeague> selectWhere(ServerLeague where);

	
    List<ServerLeague> selectAll();
    
	
	int updateBatch(List<ServerLeague> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<ServerLeague> entityList);
	
}
