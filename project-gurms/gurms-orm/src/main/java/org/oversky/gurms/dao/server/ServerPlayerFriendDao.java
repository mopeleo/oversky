package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerFriend;
import java.util.List;

public interface ServerPlayerFriendDao{

    int insert(ServerPlayerFriend entity);

    List<ServerPlayerFriend> selectAll(ServerPlayerFriend where);

    ServerPlayerFriend selectById(String serverid);

    int deleteById(String serverid);

    int updateById(ServerPlayerFriend entity);
	
    int dynamicUpdateById(ServerPlayerFriend entity);
}
