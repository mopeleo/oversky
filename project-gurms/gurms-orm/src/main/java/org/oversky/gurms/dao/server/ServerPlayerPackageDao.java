package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPlayerPackage;
import java.util.List;

public interface ServerPlayerPackageDao{

    int insert(ServerPlayerPackage entity);

    List<ServerPlayerPackage> selectAll(ServerPlayerPackage where);

    ServerPlayerPackage selectById(String serverid, Long custno, String itemid);

    int deleteById(String serverid, Long custno, String itemid);

    int updateById(ServerPlayerPackage entity);
	
    int dynamicUpdateById(ServerPlayerPackage entity);
}
