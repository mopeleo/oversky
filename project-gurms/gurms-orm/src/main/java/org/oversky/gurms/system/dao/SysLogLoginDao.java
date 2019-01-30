package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysLogLogin;
import java.util.List;

public interface SysLogLoginDao{

    int insert(SysLogLogin entity);

    List<SysLogLogin> selectWhere(SysLogLogin where);

    List<SysLogLogin> selectAll();

    SysLogLogin selectById(String logid);

    int deleteById(String logid);

    int updateById(SysLogLogin entity);
	
    int dynamicUpdateById(SysLogLogin entity);
}
