package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerMsgReceive;
import java.util.List;

public interface ServerMsgReceiveDao{

    int insert(ServerMsgReceive entity);

    List<ServerMsgReceive> selectAll(ServerMsgReceive where);

    ServerMsgReceive selectById(Long msgid);

    int deleteById(Long msgid);

    int updateById(ServerMsgReceive entity);
	
    int dynamicUpdateById(ServerMsgReceive entity);
}
