package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRoleMenu;
import java.util.List;

public interface SysRoleMenuDao{

    int insert(SysRoleMenu entity);

    List<SysRoleMenu> selectAll(SysRoleMenu where);

    SysRoleMenu selectById(Integer roleid, String menuid);

    int deleteById(Integer roleid, String menuid);

}
