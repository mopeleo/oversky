package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameActorInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameActorInfoDao{

	
    GameActorInfo getById(String actorid);

    int deleteById(String actorid);

    int updateById(GameActorInfo entity);
	
    int dynamicUpdateById(GameActorInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameActorInfo field, @Param("condition") GameActorInfo where);
    
    int count(GameActorInfo where);
    
	
    int insert(GameActorInfo entity);

	
    int deleteWhere(GameActorInfo where);

    List<GameActorInfo> selectWhere(GameActorInfo where);

	
    List<GameActorInfo> selectAll();
    
	
	int updateBatch(List<GameActorInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameActorInfo> entityList);
	
}
