package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParam;
import java.util.List;

public interface SysParamDao{

    int insert(SysParam entity);

    List<SysParam> selectWhere(SysParam where);

    List<SysParam> selectAll();

    SysParam selectById(String unioncode, Long paramid);

    int deleteById(String unioncode, Long paramid);

    int updateById(SysParam entity);
	
    int dynamicUpdateById(SysParam entity);
}
