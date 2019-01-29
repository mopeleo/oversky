package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerEquipAttribute;
import java.util.List;

public interface ServerPlayerEquipAttributeDao{

    int insert(ServerPlayerEquipAttribute entity);

    List<ServerPlayerEquipAttribute> selectAll(ServerPlayerEquipAttribute where);

    ServerPlayerEquipAttribute selectById(Long peid, String attrid);

    int deleteById(Long peid, String attrid);

    int updateById(ServerPlayerEquipAttribute entity);
	
    int dynamicUpdateById(ServerPlayerEquipAttribute entity);
}
