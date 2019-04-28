package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserLogin;
import java.util.List;

public interface SysUserLoginDao{

	
    SysUserLogin getById(Long logid);

    int deleteById(Long logid);

    int updateById(SysUserLogin entity);
	
    int dynamicUpdateById(SysUserLogin entity);
    
    int count(SysUserLogin where);
    
	
    int insert(SysUserLogin entity);

	
    int deleteWhere(SysUserLogin where);

    List<SysUserLogin> selectWhere(SysUserLogin where);

	
    List<SysUserLogin> selectAll();
    
	
	int updateBatch(List<SysUserLogin> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysUserLogin> entityList);
	
}
