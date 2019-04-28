package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysConfirmUser;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysConfirmUser")
public interface SysConfirmUserDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysConfirmUser).buildEntityKey(#p0,#p1)", unless = "#result == null")
    SysConfirmUser getById(Long userid, Integer confirmid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysConfirmUser).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(Long userid, Integer confirmid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysConfirmUser entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysConfirmUser entity);
    
    int count(SysConfirmUser where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysConfirmUser entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysConfirmUser where);

    List<SysConfirmUser> selectWhere(SysConfirmUser where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysConfirmUser> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysConfirmUser> entityList);
	
}
