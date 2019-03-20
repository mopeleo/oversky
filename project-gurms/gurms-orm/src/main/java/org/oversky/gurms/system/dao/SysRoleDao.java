package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

public interface SysRoleDao{

    SysRole getById(Long roleid);

    int deleteById(Long roleid);

    int updateById(SysRole entity);
	
    int dynamicUpdateById(SysRole entity);
    
    int count(SysRole where);
    
    int insert(SysRole entity);

    int deleteWhere(SysRole where);

    List<SysRole> selectWhere(SysRole where);

    List<SysRole> selectAll();
    
	int updateBatch(List<SysRole> entityList);
	
	int deleteBatch(Long[] ids);
	
	int insertBatch(List<SysRole> entityList);
	
}
