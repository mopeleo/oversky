package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysOrg;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysOrg")
public interface SysOrgDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysOrg).buildEntityKey(#p0)", unless = "#result == null")
    SysOrg getById(Long orgid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysOrg).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(Long orgid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysOrg entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysOrg entity);
    
    int count(SysOrg where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysOrg entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysOrg where);

    List<SysOrg> selectWhere(SysOrg where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysOrg> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<SysOrg> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(Long[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysOrg> entityList);
	
}
