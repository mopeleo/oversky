package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

public interface SysRoleDao{

    int insert(SysRole entity);

    List<SysRole> selectAll(SysRole where);

    SysRole selectById(Integer roleid);

    int deleteById(Integer roleid);

    int updateById(SysRole entity);
	
    int dynamicUpdateById(SysRole entity);
}
