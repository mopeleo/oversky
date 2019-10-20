package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerParamDao{

	
    ServerParam getById(String serverid, String paramid);

    int deleteById(String serverid, String paramid);

    int updateById(ServerParam entity);
	
    int dynamicUpdateById(ServerParam entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerParam field, @Param("condition") ServerParam where);
    
    int count(ServerParam where);
    
	
    int insert(ServerParam entity);

	
    int deleteWhere(ServerParam where);

    List<ServerParam> selectWhere(ServerParam where);

	
    List<ServerParam> selectAll();
    
	
	int insertBatch(List<ServerParam> entityList);
	
}
