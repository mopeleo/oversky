package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysParamExt;
import java.util.List;

public interface SysParamExtDao{

    int insert(SysParamExt entity);

    List<SysParamExt> selectAll(SysParamExt where);

    SysParamExt selectById(Integer paramid);

    int deleteById(Integer paramid);

    int updateById(SysParamExt entity);
	
    int dynamicUpdateById(SysParamExt entity);
}
