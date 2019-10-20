package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerLeagueInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerLeagueInfoDao{

	
    ServerLeagueInfo getById(String leagueid);

    int deleteById(String leagueid);

    int updateById(ServerLeagueInfo entity);
	
    int dynamicUpdateById(ServerLeagueInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerLeagueInfo field, @Param("condition") ServerLeagueInfo where);
    
    int count(ServerLeagueInfo where);
    
	
    int insert(ServerLeagueInfo entity);

	
    int deleteWhere(ServerLeagueInfo where);

    List<ServerLeagueInfo> selectWhere(ServerLeagueInfo where);

	
    List<ServerLeagueInfo> selectAll();
    
	
	int updateBatch(List<ServerLeagueInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<ServerLeagueInfo> entityList);
	
}
