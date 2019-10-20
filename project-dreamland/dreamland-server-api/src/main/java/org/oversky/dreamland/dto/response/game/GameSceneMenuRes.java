package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameSceneMenuRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Integer sceneid;    //
	private String menuid;    //

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sceneid=").append(sceneid);
		sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
	}
}
