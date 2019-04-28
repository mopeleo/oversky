package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserActlog;
import java.util.List;

public interface SysUserActlogDao{

	
    SysUserActlog getById(Long logid);

    int deleteById(Long logid);

    int updateById(SysUserActlog entity);
	
    int dynamicUpdateById(SysUserActlog entity);
    
    int count(SysUserActlog where);
    
	
    int insert(SysUserActlog entity);

	
    int deleteWhere(SysUserActlog where);

    List<SysUserActlog> selectWhere(SysUserActlog where);

	
    List<SysUserActlog> selectAll();
    
	
	int updateBatch(List<SysUserActlog> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysUserActlog> entityList);
	
}
