package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerEquip;
import java.util.List;

public interface ServerPlayerEquipDao{

    int insert(ServerPlayerEquip entity);

    List<ServerPlayerEquip> selectAll(ServerPlayerEquip where);

    ServerPlayerEquip selectById(String serverid, Long custno, String equipid);

    int deleteById(String serverid, Long custno, String equipid);

    int updateById(ServerPlayerEquip entity);
	
    int dynamicUpdateById(ServerPlayerEquip entity);
}
