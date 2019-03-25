package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysRole")
public interface SysRoleDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysRole).buildEntityKey(#p0)")
    SysRole getById(Long roleid);

	@CacheEvict(key = "'roleid:' + #roleid")
    int deleteById(Long roleid);

	@CacheEvict(key = "'roleid:' + #roleid")
    int updateById(SysRole entity);
	
	@CacheEvict(key = "'roleid:' + #roleid")
    int dynamicUpdateById(SysRole entity);
    
    int count(SysRole where);
    
    int insert(SysRole entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysRole where);

    List<SysRole> selectWhere(SysRole where);

	@Cacheable(key = "selectAll")
    List<SysRole> selectAll();
    
	@CacheEvict(allEntries=true)
	int updateBatch(List<SysRole> entityList);
	
	@CacheEvict(allEntries=true)
	int deleteBatch(Long[] ids);
	
	int insertBatch(List<SysRole> entityList);
	
}
