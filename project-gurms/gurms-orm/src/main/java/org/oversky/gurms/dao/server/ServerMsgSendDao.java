package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerMsgSend;
import java.util.List;

public interface ServerMsgSendDao{

    int insert(ServerMsgSend entity);

    List<ServerMsgSend> selectAll(ServerMsgSend where);

    ServerMsgSend selectById(Long msgid);

    int deleteById(Long msgid);

    int updateById(ServerMsgSend entity);
	
    int dynamicUpdateById(ServerMsgSend entity);
}
