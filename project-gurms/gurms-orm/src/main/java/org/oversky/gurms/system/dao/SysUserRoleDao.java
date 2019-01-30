package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserRole;
import java.util.List;

public interface SysUserRoleDao{

    int insert(SysUserRole entity);

    List<SysUserRole> selectAll(SysUserRole where);

    SysUserRole selectById(Long userid, Integer roleid);

    int deleteById(Long userid, Integer roleid);

}
