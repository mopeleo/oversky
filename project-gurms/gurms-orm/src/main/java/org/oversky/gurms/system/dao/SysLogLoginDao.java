package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysLogLogin;
import java.util.List;

public interface SysLogLoginDao{

    SysLogLogin getById(Long logid);

    int deleteById(Long logid);

    int updateById(SysLogLogin entity);
	
    int dynamicUpdateById(SysLogLogin entity);
    
    int count(SysLogLogin where);
    
    int insert(SysLogLogin entity);

    List<SysLogLogin> selectWhere(SysLogLogin where);

    List<SysLogLogin> selectAll();
}