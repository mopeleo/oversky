package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameActorSkill;
import java.util.List;

public interface GameActorSkillDao{

    int insert(GameActorSkill entity);

    List<GameActorSkill> selectAll(GameActorSkill where);

    GameActorSkill selectById(String actorid, String skillid);

    int deleteById(String actorid, String skillid);

    int updateById(GameActorSkill entity);
	
    int dynamicUpdateById(GameActorSkill entity);
}
