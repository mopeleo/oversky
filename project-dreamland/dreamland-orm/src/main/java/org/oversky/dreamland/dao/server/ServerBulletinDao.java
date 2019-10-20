package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerBulletin;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerBulletinDao{

	
    ServerBulletin getById(Long id);

    int deleteById(Long id);

    int updateById(ServerBulletin entity);
	
    int dynamicUpdateById(ServerBulletin entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerBulletin field, @Param("condition") ServerBulletin where);
    
    int count(ServerBulletin where);
    
	
    int insert(ServerBulletin entity);

	
    int deleteWhere(ServerBulletin where);

    List<ServerBulletin> selectWhere(ServerBulletin where);

	
    List<ServerBulletin> selectAll();
    
	
	int updateBatch(List<ServerBulletin> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<ServerBulletin> entityList);
	
}
