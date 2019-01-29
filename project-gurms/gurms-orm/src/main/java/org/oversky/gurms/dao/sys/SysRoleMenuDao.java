package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysRoleMenu;
import java.util.List;

public interface SysRoleMenuDao{

    int insert(SysRoleMenu entity);

    List<SysRoleMenu> selectAll(SysRoleMenu where);

    SysRoleMenu selectById(Integer roleid, String menuid);

    int deleteById(Integer roleid, String menuid);

}
