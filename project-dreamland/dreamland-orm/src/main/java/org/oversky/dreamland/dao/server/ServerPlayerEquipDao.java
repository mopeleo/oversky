package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerEquip;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerEquipDao{

	
    ServerPlayerEquip getById(String serverid, Long custno, String equipid);

    int deleteById(String serverid, Long custno, String equipid);

    int updateById(ServerPlayerEquip entity);
	
    int dynamicUpdateById(ServerPlayerEquip entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerEquip field, @Param("condition") ServerPlayerEquip where);
    
    int count(ServerPlayerEquip where);
    
	
    int insert(ServerPlayerEquip entity);

	
    int deleteWhere(ServerPlayerEquip where);

    List<ServerPlayerEquip> selectWhere(ServerPlayerEquip where);

	
    List<ServerPlayerEquip> selectAll();
    
	
	int insertBatch(List<ServerPlayerEquip> entityList);
	
}
