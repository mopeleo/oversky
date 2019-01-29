package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerInfo;
import java.util.List;

public interface ServerInfoDao{

    int insert(ServerInfo entity);

    List<ServerInfo> selectAll(ServerInfo where);

    ServerInfo selectById(String serverid);

    int deleteById(String serverid);

    int updateById(ServerInfo entity);
	
    int dynamicUpdateById(ServerInfo entity);
}
