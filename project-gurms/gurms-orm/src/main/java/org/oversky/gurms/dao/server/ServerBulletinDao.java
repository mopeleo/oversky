package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerBulletin;
import java.util.List;

public interface ServerBulletinDao{

    int insert(ServerBulletin entity);

    List<ServerBulletin> selectAll(ServerBulletin where);

    ServerBulletin selectById(Long id);

    int deleteById(Long id);

    int updateById(ServerBulletin entity);
	
    int dynamicUpdateById(ServerBulletin entity);
}
