package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao{

	
    SysUser getById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUser entity);
	
    int dynamicUpdateById(SysUser entity);
    
	
    int dynamicUpdateWhere(@Param("field") SysUser field, @Param("condition") SysUser where);
    
    int count(SysUser where);
    
	
    int insert(SysUser entity);

	
    int deleteWhere(SysUser where);

    List<SysUser> selectWhere(SysUser where);

	
    List<SysUser> selectAll();
    
	
	int updateBatch(List<SysUser> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysUser> entityList);
	
}
