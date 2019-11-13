package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerPackage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerPackageDao{

	
    ServerPlayerPackage getById(String serverid, Long custno, Long itemid);

    int deleteById(String serverid, Long custno, Long itemid);

    int updateById(ServerPlayerPackage entity);
	
    int dynamicUpdateById(ServerPlayerPackage entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerPackage field, @Param("condition") ServerPlayerPackage where);
    
    int count(ServerPlayerPackage where);
    
	
    int insert(ServerPlayerPackage entity);

	
    int deleteWhere(ServerPlayerPackage where);

    List<ServerPlayerPackage> selectWhere(ServerPlayerPackage where);

	
    List<ServerPlayerPackage> selectAll();
    
	
	int insertBatch(List<ServerPlayerPackage> entityList);
	
}
