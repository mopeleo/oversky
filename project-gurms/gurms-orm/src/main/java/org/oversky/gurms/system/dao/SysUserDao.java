package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUser;
import java.util.List;

public interface SysUserDao{

	
    SysUser getById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUser entity);
	
    int dynamicUpdateById(SysUser entity);
    
    int count(SysUser where);
    
	
    int insert(SysUser entity);

	
    int deleteWhere(SysUser where);

    List<SysUser> selectWhere(SysUser where);

	
    List<SysUser> selectAll();
    
	
	int updateBatch(List<SysUser> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysUser> entityList);
	
}
