package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerMsgSend;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerMsgSendDao{

	
    ServerMsgSend getById(Long msgid);

    int deleteById(Long msgid);

    int updateById(ServerMsgSend entity);
	
    int dynamicUpdateById(ServerMsgSend entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerMsgSend field, @Param("condition") ServerMsgSend where);
    
    int count(ServerMsgSend where);
    
	
    int insert(ServerMsgSend entity);

	
    int deleteWhere(ServerMsgSend where);

    List<ServerMsgSend> selectWhere(ServerMsgSend where);

	
    List<ServerMsgSend> selectAll();
    
	
	int updateBatch(List<ServerMsgSend> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<ServerMsgSend> entityList);
	
}
