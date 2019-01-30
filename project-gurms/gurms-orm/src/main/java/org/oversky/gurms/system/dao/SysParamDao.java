package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParam;
import java.util.List;

public interface SysParamDao{

    int insert(SysParam entity);

    List<SysParam> selectAll(SysParam where);

    SysParam selectById(String unioncode, Integer paramid);

    int deleteById(String unioncode, Integer paramid);

    int updateById(SysParam entity);
	
    int dynamicUpdateById(SysParam entity);
}
