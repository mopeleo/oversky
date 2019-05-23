package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "SysMenu")
public interface SysMenuDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysMenu).buildEntityKey(#p0)", unless = "#result == null")
    SysMenu getById(String menuid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.gurms.system.entity.SysMenu).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(String menuid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(SysMenu entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(SysMenu entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") SysMenu field, @Param("condition") SysMenu where);
    
    int count(SysMenu where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(SysMenu entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(SysMenu where);

    List<SysMenu> selectWhere(SysMenu where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<SysMenu> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<SysMenu> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(String[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<SysMenu> entityList);
	
}
