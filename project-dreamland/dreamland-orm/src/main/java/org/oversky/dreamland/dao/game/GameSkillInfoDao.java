package org.oversky.dreamland.dao.game;

import org.oversky.dreamland.entity.game.GameSkillInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameSkillInfoDao{

	
    GameSkillInfo getById(String skillid);

    int deleteById(String skillid);

    int updateById(GameSkillInfo entity);
	
    int dynamicUpdateById(GameSkillInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") GameSkillInfo field, @Param("condition") GameSkillInfo where);
    
    int count(GameSkillInfo where);
    
	
    int insert(GameSkillInfo entity);

	
    int deleteWhere(GameSkillInfo where);

    List<GameSkillInfo> selectWhere(GameSkillInfo where);

	
    List<GameSkillInfo> selectAll();
    
	
	int updateBatch(List<GameSkillInfo> entityList);
	
	
	int deleteBatch(String[] ids);
	
	
	int insertBatch(List<GameSkillInfo> entityList);
	
}
