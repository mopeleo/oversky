package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameSceneMenu;
import java.util.List;

public interface GameSceneMenuDao{

    int insert(GameSceneMenu entity);

    List<GameSceneMenu> selectAll(GameSceneMenu where);

    GameSceneMenu selectById(Integer sceneid, String menuid);

    int deleteById(Integer sceneid, String menuid);

}
