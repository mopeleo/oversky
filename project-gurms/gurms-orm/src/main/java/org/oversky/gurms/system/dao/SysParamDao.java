package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysParam;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysParam")
public interface SysParamDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysParam).buildEntityKey(#p0,)#p1)", unless = "#result == null")
    SysParam getById(String unioncode, Long paramid);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'paramid:' + #paramid")
    int deleteById(String unioncode, Long paramid);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'paramid:' + #paramid")
    int updateById(SysParam entity);
	
	@CacheEvict(key = "'unioncode:' + #unioncode + 'paramid:' + #paramid")
    int dynamicUpdateById(SysParam entity);
    
    int count(SysParam where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysParam entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysParam where);

    List<SysParam> selectWhere(SysParam where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysParam> selectAll();
    
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysParam> entityList);
	
}
