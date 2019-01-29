package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerActorFavor;
import java.util.List;

public interface ServerPlayerActorFavorDao{

    int insert(ServerPlayerActorFavor entity);

    List<ServerPlayerActorFavor> selectAll(ServerPlayerActorFavor where);

    ServerPlayerActorFavor selectById(String serverid, String maleid, String femaleid);

    int deleteById(String serverid, String maleid, String femaleid);

    int updateById(ServerPlayerActorFavor entity);
	
    int dynamicUpdateById(ServerPlayerActorFavor entity);
}
