package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysOrg;
import java.util.List;

public interface SysOrgDao{

    int insert(SysOrg entity);

    List<SysOrg> selectAll(SysOrg where);

    SysOrg selectById(String orgid);

    int deleteById(String orgid);

    int updateById(SysOrg entity);
	
    int dynamicUpdateById(SysOrg entity);
}
