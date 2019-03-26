package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParamExt;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysParamExt")
public interface SysParamExtDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysParamExt).buildEntityKey(#p0)", unless = "#result == null")
    SysParamExt getById(Long paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysParamExt).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(Long paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysParamExt entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysParamExt entity);
    
    int count(SysParamExt where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysParamExt entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysParamExt where);

    List<SysParamExt> selectWhere(SysParamExt where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysParamExt> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<SysParamExt> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(Long[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysParamExt> entityList);
	
}
