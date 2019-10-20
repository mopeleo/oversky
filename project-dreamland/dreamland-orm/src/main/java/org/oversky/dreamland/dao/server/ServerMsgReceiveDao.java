package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerMsgReceive;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerMsgReceiveDao{

	
    ServerMsgReceive getById(Long msgid);

    int deleteById(Long msgid);

    int updateById(ServerMsgReceive entity);
	
    int dynamicUpdateById(ServerMsgReceive entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerMsgReceive field, @Param("condition") ServerMsgReceive where);
    
    int count(ServerMsgReceive where);
    
	
    int insert(ServerMsgReceive entity);

	
    int deleteWhere(ServerMsgReceive where);

    List<ServerMsgReceive> selectWhere(ServerMsgReceive where);

	
    List<ServerMsgReceive> selectAll();
    
	
	int updateBatch(List<ServerMsgReceive> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<ServerMsgReceive> entityList);
	
}
