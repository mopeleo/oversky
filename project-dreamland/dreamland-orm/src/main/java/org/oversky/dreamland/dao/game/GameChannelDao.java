package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameChannel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameChannelDao{

	
    GameChannel getById(Integer channelid);

    int deleteById(Integer channelid);

    int updateById(GameChannel entity);
	
    int dynamicUpdateById(GameChannel entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameChannel field, @Param("condition") GameChannel where);
    
    int count(GameChannel where);
    
	
    int insert(GameChannel entity);

	
    int deleteWhere(GameChannel where);

    List<GameChannel> selectWhere(GameChannel where);

	
    List<GameChannel> selectAll();
    
	
	int updateBatch(List<GameChannel> entityList);
	
	
	int deleteBatch(Integer[] ids);
	
	
	int insertBatch(List<GameChannel> entityList);
	
}
