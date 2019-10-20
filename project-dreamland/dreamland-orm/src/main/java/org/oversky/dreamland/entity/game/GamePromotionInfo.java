package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GamePromotionInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer promid;    //
	private String promname;    //
	private String remark;    //

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
		this.promid = promid;
	}

	public String getPromname() {
		return this.promname;
	}

	public void setPromname(String promname) {
		this.promname = promname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GamePromotionInfo");
		return build.append("#promid:").append(this.promid).toString();
	}

    public static String buildEntityKey(Integer promid){
        StringBuilder build = new StringBuilder("GamePromotionInfo");
        return build.append("#promid:").append(promid).toString();
    }
    
    public void copyPrimaryKey(GamePromotionInfo entity){
		this.promid = entity.getPromid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", promid=").append(promid);
		sb.append(", promname=").append(promname);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
