package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserInfo;
import java.util.List;

public interface SysUserInfoDao{

	
    SysUserInfo getById(Long userid);

	
    int deleteById(Long userid);

	
    int updateById(SysUserInfo entity);
	
	
    int dynamicUpdateById(SysUserInfo entity);
    
    int count(SysUserInfo where);
    
    int insert(SysUserInfo entity);

	
    int deleteWhere(SysUserInfo where);

    List<SysUserInfo> selectWhere(SysUserInfo where);

	
    List<SysUserInfo> selectAll();
    
	
	int updateBatch(List<SysUserInfo> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	int insertBatch(List<SysUserInfo> entityList);
	
}
