package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPlayerFriend;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPlayerFriendDao{

	
    ServerPlayerFriend getById(String serverid);

    int deleteById(String serverid);

    int updateById(ServerPlayerFriend entity);
	
    int dynamicUpdateById(ServerPlayerFriend entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPlayerFriend field, @Param("condition") ServerPlayerFriend where);
    
    int count(ServerPlayerFriend where);
    
	
    int insert(ServerPlayerFriend entity);

	
    int deleteWhere(ServerPlayerFriend where);

    List<ServerPlayerFriend> selectWhere(ServerPlayerFriend where);

	
    List<ServerPlayerFriend> selectAll();
    
	
	int updateBatch(List<ServerPlayerFriend> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<ServerPlayerFriend> entityList);
	
}
