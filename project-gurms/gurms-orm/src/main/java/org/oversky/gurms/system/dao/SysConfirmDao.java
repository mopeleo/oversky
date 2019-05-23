package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysConfirm;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysConfirm")
public interface SysConfirmDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysConfirm).buildEntityKey(#p0,#p1)", unless = "#result == null")
    SysConfirm getById(String unioncode, String tablename);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysConfirm).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(String unioncode, String tablename);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysConfirm entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysConfirm entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") SysConfirm field, @Param("condition") SysConfirm where);
    
    int count(SysConfirm where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysConfirm entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysConfirm where);

    List<SysConfirm> selectWhere(SysConfirm where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysConfirm> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysConfirm> entityList);
	
}
