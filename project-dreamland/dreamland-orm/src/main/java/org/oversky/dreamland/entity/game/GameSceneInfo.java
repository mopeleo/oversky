package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameSceneInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long sceneid;    //场景ID[identity]
	private String scenename;    //场景名称

	public Long getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Long sceneid) {
		this.sceneid = sceneid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneInfo");
		return build.append("#sceneid:").append(this.sceneid).toString();
	}

    public static String buildEntityKey(Long sceneid){
        StringBuilder build = new StringBuilder("GameSceneInfo");
        return build.append("#sceneid:").append(sceneid).toString();
    }
    
    public void copyPrimaryKey(GameSceneInfo entity){
		this.sceneid = entity.getSceneid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("sceneid=").append(sceneid).append(", ");
		sb.append("scenename=").append(scenename).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
