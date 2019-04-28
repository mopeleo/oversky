package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParamInfo;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysParamInfo")
public interface SysParamInfoDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysParamInfo).buildEntityKey(#p0)", unless = "#result == null")
    SysParamInfo getById(Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysParamInfo).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysParamInfo entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysParamInfo entity);
    
    int count(SysParamInfo where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysParamInfo entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysParamInfo where);

    List<SysParamInfo> selectWhere(SysParamInfo where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysParamInfo> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<SysParamInfo> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(Integer[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysParamInfo> entityList);
	
}
