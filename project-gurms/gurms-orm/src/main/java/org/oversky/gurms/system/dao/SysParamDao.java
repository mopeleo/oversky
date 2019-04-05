package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParam;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysParam")
public interface SysParamDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysParam).buildEntityKey(#p0,#p1)", unless = "#result == null")
    SysParam getById(String unioncode, Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysParam).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(String unioncode, Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysParam entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysParam entity);
    
    int count(SysParam where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysParam entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysParam where);

    List<SysParam> selectWhere(SysParam where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysParam> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysParam> entityList);
	
}
