package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerInfoDao{

	
    ServerInfo getById(String serverid);

    int deleteById(String serverid);

    int updateById(ServerInfo entity);
	
    int dynamicUpdateById(ServerInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerInfo field, @Param("condition") ServerInfo where);
    
    int count(ServerInfo where);
    
	
    int insert(ServerInfo entity);

	
    int deleteWhere(ServerInfo where);

    List<ServerInfo> selectWhere(ServerInfo where);

	
    List<ServerInfo> selectAll();
    
	
	int updateBatch(List<ServerInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<ServerInfo> entityList);
	
}
