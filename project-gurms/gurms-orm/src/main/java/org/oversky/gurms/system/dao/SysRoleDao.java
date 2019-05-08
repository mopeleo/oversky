package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysRole;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysRole")
public interface SysRoleDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysRole).buildEntityKey(#p0)", unless = "#result == null")
    SysRole getById(Long roleid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysRole).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(Long roleid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysRole entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysRole entity);
    
    int count(SysRole where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysRole entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysRole where);

    List<SysRole> selectWhere(SysRole where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysRole> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<SysRole> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(Long[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysRole> entityList);
	
}
