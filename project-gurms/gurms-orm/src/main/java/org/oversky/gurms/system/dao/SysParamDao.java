package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParam;
import java.util.List;

public interface SysParamDao{

    SysParam getById(String unioncode, Long paramid);

    int deleteById(String unioncode, Long paramid);

    int updateById(SysParam entity);
	
    int dynamicUpdateById(SysParam entity);
    
    int count(SysParam where);
    
    int insert(SysParam entity);

    List<SysParam> selectWhere(SysParam where);

    List<SysParam> selectAll();
}
