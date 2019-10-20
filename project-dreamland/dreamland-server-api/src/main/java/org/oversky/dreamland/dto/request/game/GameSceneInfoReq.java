package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameSceneInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Integer sceneid;    //场景ID
	private String scenename;    //场景名称

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sceneid=").append(sceneid);
		sb.append(", scenename=").append(scenename);
        sb.append("]");
        return sb.toString();
	}
}
