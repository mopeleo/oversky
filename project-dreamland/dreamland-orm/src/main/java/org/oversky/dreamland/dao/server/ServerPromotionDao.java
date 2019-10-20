package org.oversky.dreamland.dao.server;

import org.oversky.dreamland.entity.server.ServerPromotion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerPromotionDao{

	
    ServerPromotion getById(String serverid, Integer promid);

    int deleteById(String serverid, Integer promid);

    int updateById(ServerPromotion entity);
	
    int dynamicUpdateById(ServerPromotion entity);
    
	
    int dynamicUpdateWhere(@Param("field") ServerPromotion field, @Param("condition") ServerPromotion where);
    
    int count(ServerPromotion where);
    
	
    int insert(ServerPromotion entity);

	
    int deleteWhere(ServerPromotion where);

    List<ServerPromotion> selectWhere(ServerPromotion where);

	
    List<ServerPromotion> selectAll();
    
	
	int insertBatch(List<ServerPromotion> entityList);
	
}
