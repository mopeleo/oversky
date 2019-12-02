package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameSceneMenuReq extends BaseReqDto {

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("sceneid=").append(sceneid).append(", ");
		sb.append("menuid=").append(menuid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
