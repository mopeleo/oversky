package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParamExt;
import java.util.List;

public interface SysParamExtDao{

    SysParamExt getById(Long paramid);

    int deleteById(Long paramid);

    int updateById(SysParamExt entity);
	
    int dynamicUpdateById(SysParamExt entity);
    
    int count(SysParamExt where);
    
    int insert(SysParamExt entity);

    List<SysParamExt> selectWhere(SysParamExt where);

    List<SysParamExt> selectAll();
    
	int updateBatch(List<SysParamExt> entityList);
	
	int insertBatch(List<SysParamExt> entityList);
	
}
