package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameEquipSkill;
import java.util.List;

public interface GameEquipSkillDao{

    int insert(GameEquipSkill entity);

    List<GameEquipSkill> selectAll(GameEquipSkill where);

    GameEquipSkill selectById(String equipid, String skillid);

    int deleteById(String equipid, String skillid);

    int updateById(GameEquipSkill entity);
	
    int dynamicUpdateById(GameEquipSkill entity);
}
