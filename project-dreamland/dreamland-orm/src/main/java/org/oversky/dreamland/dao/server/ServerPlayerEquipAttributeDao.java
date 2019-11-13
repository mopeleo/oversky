package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerEquipAttribute;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerEquipAttributeDao{

	
    ServerPlayerEquipAttribute getById(Long peid, Long attrid);

    int deleteById(Long peid, Long attrid);

    int updateById(ServerPlayerEquipAttribute entity);
	
    int dynamicUpdateById(ServerPlayerEquipAttribute entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerEquipAttribute field, @Param("condition") ServerPlayerEquipAttribute where);
    
    int count(ServerPlayerEquipAttribute where);
    
	
    int insert(ServerPlayerEquipAttribute entity);

	
    int deleteWhere(ServerPlayerEquipAttribute where);

    List<ServerPlayerEquipAttribute> selectWhere(ServerPlayerEquipAttribute where);

	
    List<ServerPlayerEquipAttribute> selectAll();
    
	
	int insertBatch(List<ServerPlayerEquipAttribute> entityList);
	
}
