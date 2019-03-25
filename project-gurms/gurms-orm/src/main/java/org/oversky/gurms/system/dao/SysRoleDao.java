package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysRole")
public interface SysRoleDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysRole).buildEntityKey(#p0)", unless = "#result == null")
    SysRole getById(Long roleid);

	@CacheEvict(key = "'roleid:' + #roleid")
    int deleteById(Long roleid);

	@CacheEvict(key = "'roleid:' + #roleid")
    int updateById(SysRole entity);
	
	@CacheEvict(key = "'roleid:' + #roleid")
    int dynamicUpdateById(SysRole entity);
    
    int count(SysRole where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysRole entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysRole where);

    List<SysRole> selectWhere(SysRole where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysRole> selectAll();
    
	@CacheEvict(allEntries=true)
	int updateBatch(List<SysRole> entityList);
	
	@CacheEvict(allEntries=true)
	int deleteBatch(Long[] ids);
	
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysRole> entityList);
	
}
