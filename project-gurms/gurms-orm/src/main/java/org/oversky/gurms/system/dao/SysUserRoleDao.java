package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserRole;
import java.util.List;

public interface SysUserRoleDao{

    int insert(SysUserRole entity);

    List<SysUserRole> selectWhere(SysUserRole where);

    List<SysUserRole> selectAll();

    SysUserRole selectById(Long userid, Long roleid);

    int deleteById(Long userid, Long roleid);

}
