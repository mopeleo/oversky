package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysLogLogin;
import java.util.List;

public interface SysLogLoginDao{

    int insert(SysLogLogin entity);

    List<SysLogLogin> selectAll(SysLogLogin where);

    SysLogLogin selectById(String logid);

    int deleteById(String logid);

    int updateById(SysLogLogin entity);
	
    int dynamicUpdateById(SysLogLogin entity);
}
