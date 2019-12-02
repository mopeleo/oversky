package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameLevel extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long levelid;    //等级ID[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String levelname;    //等级名称
	private Integer nextlevel;    //下一等级
	private String icon;    //等级图标
	private Integer minpoint;    //经验下限（包含）
	private Integer maxpoint;    //等级上限（不包含）
	private String leveltype;    //0，会员等级，1角色等级，2工会等级，3装备等级，4技能等级
	private String remark;    //

	public Long getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Long levelid) {
		this.levelid = levelid;
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

	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public Integer getNextlevel() {
		return this.nextlevel;
	}

	public void setNextlevel(Integer nextlevel) {
		this.nextlevel = nextlevel;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(Integer minpoint) {
		this.minpoint = minpoint;
	}

	public Integer getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(Integer maxpoint) {
		this.maxpoint = maxpoint;
	}

	public String getLeveltype() {
		return this.leveltype;
	}

	public void setLeveltype(String leveltype) {
		this.leveltype = leveltype;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameLevel");
		return build.append("#levelid:").append(this.levelid).toString();
	}

    public static String buildEntityKey(Long levelid){
        StringBuilder build = new StringBuilder("GameLevel");
        return build.append("#levelid:").append(levelid).toString();
    }
    
    public void copyPrimaryKey(GameLevel entity){
		this.levelid = entity.getLevelid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("levelid=").append(levelid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("levelname=").append(levelname).append(", ");
		sb.append("nextlevel=").append(nextlevel).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("minpoint=").append(minpoint).append(", ");
		sb.append("maxpoint=").append(maxpoint).append(", ");
		sb.append("leveltype=").append(leveltype).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
