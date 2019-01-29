package org.oversky.gurms.dao.server;

import org.oversky.gurms.entity.server.ServerPromotion;
import java.util.List;

public interface ServerPromotionDao{

    int insert(ServerPromotion entity);

    List<ServerPromotion> selectAll(ServerPromotion where);

    ServerPromotion selectById(String serverid, Integer promid);

    int deleteById(String serverid, Integer promid);

    int updateById(ServerPromotion entity);
	
    int dynamicUpdateById(ServerPromotion entity);
}
