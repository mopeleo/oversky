package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameLevelInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Integer levelid;    //等级ID
	private String levelname;    //等级名称
	private Integer nextlevel;    //下一等级
	private String icon;    //等级图标
	private Integer minpoint;    //经验下限（包含）
	private Integer maxpoint;    //等级上限（不包含）
	private String leveltype;    //0，会员等级，1角色等级，2工会等级，3装备等级，4技能等级
	private String remark;    //

	public Integer getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Integer levelid) {
		this.levelid = levelid;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", levelid=").append(levelid);
		sb.append(", levelname=").append(levelname);
		sb.append(", nextlevel=").append(nextlevel);
		sb.append(", icon=").append(icon);
		sb.append(", minpoint=").append(minpoint);
		sb.append(", maxpoint=").append(maxpoint);
		sb.append(", leveltype=").append(leveltype);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
