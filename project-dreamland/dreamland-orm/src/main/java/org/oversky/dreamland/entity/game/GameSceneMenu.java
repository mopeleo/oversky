package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameSceneMenu extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long sceneid;    //
	private Long menuid;    //

	public Long getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Long sceneid) {
		this.sceneid = sceneid;
	}

	public Long getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneMenu");
		return build.append("#sceneid:").append(this.sceneid).append("#menuid:").append(this.menuid).toString();
	}

    public static String buildEntityKey(Long sceneid, Long menuid){
        StringBuilder build = new StringBuilder("GameSceneMenu");
        return build.append("#sceneid:").append(sceneid).append("#menuid:").append(menuid).toString();
    }
    
    public void copyPrimaryKey(GameSceneMenu entity){
		this.sceneid = entity.getSceneid();
		this.menuid = entity.getMenuid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("sceneid=").append(sceneid).append(", ");
		sb.append("menuid=").append(menuid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
