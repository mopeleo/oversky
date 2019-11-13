package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameSceneInfoRes extends BaseResDto {

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
		sb.append("sceneid=").append(sceneid).append(", ");
		sb.append("scenename=").append(scenename).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
