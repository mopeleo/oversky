package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameScene extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long sceneid;    //场景ID[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String scenename;    //场景名称

	public Long getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Long sceneid) {
		this.sceneid = sceneid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameScene");
		return build.append("#sceneid:").append(this.sceneid).toString();
	}

    public static String buildEntityKey(Long sceneid){
        StringBuilder build = new StringBuilder("GameScene");
        return build.append("#sceneid:").append(sceneid).toString();
    }
    
    public void copyPrimaryKey(GameScene entity){
		this.sceneid = entity.getSceneid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("sceneid=").append(sceneid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("scenename=").append(scenename).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
