package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysOrg;
import java.util.List;

public interface SysOrgDao{

    int insert(SysOrg entity);

    List<SysOrg> selectWhere(SysOrg where);

    List<SysOrg> selectAll();

    SysOrg selectById(String orgid);

    int deleteById(String orgid);

    int updateById(SysOrg entity);
	
    int dynamicUpdateById(SysOrg entity);
}
