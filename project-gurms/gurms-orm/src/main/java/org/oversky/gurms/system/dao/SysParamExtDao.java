package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParamExt;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysParamExt")
public interface SysParamExtDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysParamExt).buildEntityKey(#p0)", unless = "#result == null")
    SysParamExt getById(Long paramid);

	@CacheEvict(key = "'paramid:' + #paramid")
    int deleteById(Long paramid);

	@CacheEvict(key = "'paramid:' + #paramid")
    int updateById(SysParamExt entity);
	
	@CacheEvict(key = "'paramid:' + #paramid")
    int dynamicUpdateById(SysParamExt entity);
    
    int count(SysParamExt where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysParamExt entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysParamExt where);

    List<SysParamExt> selectWhere(SysParamExt where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysParamExt> selectAll();
    
	@CacheEvict(allEntries=true)
	int updateBatch(List<SysParamExt> entityList);
	
	@CacheEvict(allEntries=true)
	int deleteBatch(Long[] ids);
	
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysParamExt> entityList);
	
}
