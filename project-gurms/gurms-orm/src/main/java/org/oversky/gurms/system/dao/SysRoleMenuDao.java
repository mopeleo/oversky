package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRoleMenu;
import java.util.List;

public interface SysRoleMenuDao{

    int insert(SysRoleMenu entity);

    List<SysRoleMenu> selectWhere(SysRoleMenu where);

    List<SysRoleMenu> selectAll();

    SysRoleMenu selectById(Long roleid, String menuid);

    int deleteById(Long roleid, String menuid);

}
