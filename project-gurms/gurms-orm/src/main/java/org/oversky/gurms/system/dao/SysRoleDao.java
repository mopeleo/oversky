package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

public interface SysRoleDao{

    int insert(SysRole entity);

    List<SysRole> selectWhere(SysRole where);

    List<SysRole> selectAll();

    SysRole selectById(Long roleid);

    int deleteById(Long roleid);

    int updateById(SysRole entity);
	
    int dynamicUpdateById(SysRole entity);
}
