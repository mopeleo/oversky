package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRoleMenu;
import java.util.List;

public interface SysRoleMenuDao{

	
    SysRoleMenu getById(Long roleid, String menuid);

    int deleteById(Long roleid, String menuid);

    int count(SysRoleMenu where);
    
	
    int insert(SysRoleMenu entity);

	
    int deleteWhere(SysRoleMenu where);

    List<SysRoleMenu> selectWhere(SysRoleMenu where);

	
    List<SysRoleMenu> selectAll();
    
	
	int insertBatch(List<SysRoleMenu> entityList);
	
}
