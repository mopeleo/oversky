package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerInfo;
import java.util.List;

public interface ServerPlayerInfoDao{

    int insert(ServerPlayerInfo entity);

    List<ServerPlayerInfo> selectAll(ServerPlayerInfo where);

    ServerPlayerInfo selectById(String serverid, Long custno);

    int deleteById(String serverid, Long custno);

    int updateById(ServerPlayerInfo entity);
	
    int dynamicUpdateById(ServerPlayerInfo entity);
}
