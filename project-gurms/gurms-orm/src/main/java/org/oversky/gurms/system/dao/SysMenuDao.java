package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysMenu;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysMenu")
public interface SysMenuDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysMenu).buildEntityKey(#p0)", unless = "#result == null")
    SysMenu getById(String menuid);

	@CacheEvict(key = "'menuid:' + #menuid")
    int deleteById(String menuid);

	@CacheEvict(key = "'menuid:' + #menuid")
    int updateById(SysMenu entity);
	
	@CacheEvict(key = "'menuid:' + #menuid")
    int dynamicUpdateById(SysMenu entity);
    
    int count(SysMenu where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysMenu entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysMenu where);

    List<SysMenu> selectWhere(SysMenu where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysMenu> selectAll();
    
	@CacheEvict(allEntries=true)
	int updateBatch(List<SysMenu> entityList);
	
	@CacheEvict(allEntries=true)
	int deleteBatch(String[] ids);
	
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysMenu> entityList);
	
}
