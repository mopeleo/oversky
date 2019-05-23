package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictValue;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysDictValue")
public interface SysDictValueDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysDictValue).buildEntityKey(#p0,#p1,#p2)", unless = "#result == null")
    SysDictValue getById(String unioncode, Integer dictcode, String itemcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysDictValue).buildEntityKey(#p0,#p1,#p2)", condition = "#result == 1")
	})
    int deleteById(String unioncode, Integer dictcode, String itemcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysDictValue entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysDictValue entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") SysDictValue field, @Param("condition") SysDictValue where);
    
    int count(SysDictValue where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysDictValue entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysDictValue where);

    List<SysDictValue> selectWhere(SysDictValue where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysDictValue> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysDictValue> entityList);
	
}
