package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameSuitEquip;
import java.util.List;

public interface GameSuitEquipDao{

    int insert(GameSuitEquip entity);

    List<GameSuitEquip> selectAll(GameSuitEquip where);

    GameSuitEquip selectById(String suitid, String equipid);

    int deleteById(String suitid, String equipid);

}
