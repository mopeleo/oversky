package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictIndex;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysDictIndex")
public interface SysDictIndexDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysDictIndex).buildEntityKey(#p0,#p1)", unless = "#result == null")
    SysDictIndex getById(String unioncode, Integer dictcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysDictIndex).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(String unioncode, Integer dictcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysDictIndex entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysDictIndex entity);
    
    int count(SysDictIndex where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysDictIndex entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysDictIndex where);

    List<SysDictIndex> selectWhere(SysDictIndex where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysDictIndex> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysDictIndex> entityList);
	
}
