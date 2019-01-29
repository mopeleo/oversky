package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysParam;
import java.util.List;

public interface SysParamDao{

    int insert(SysParam entity);

    List<SysParam> selectAll(SysParam where);

    SysParam selectById(String unioncode, Integer paramid);

    int deleteById(String unioncode, Integer paramid);

    int updateById(SysParam entity);
	
    int dynamicUpdateById(SysParam entity);
}
