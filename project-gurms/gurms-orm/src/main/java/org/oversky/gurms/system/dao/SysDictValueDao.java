package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictValue;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysDictValue")
public interface SysDictValueDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysDictValue).buildEntityKey(#p0,)#p1,)#p2)", unless = "#result == null")
    SysDictValue getById(String unioncode, Long dictcode, String itemcode);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode + 'itemcode:' + #itemcode")
    int deleteById(String unioncode, Long dictcode, String itemcode);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode + 'itemcode:' + #itemcode")
    int updateById(SysDictValue entity);
	
	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode + 'itemcode:' + #itemcode")
    int dynamicUpdateById(SysDictValue entity);
    
    int count(SysDictValue where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysDictValue entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysDictValue where);

    List<SysDictValue> selectWhere(SysDictValue where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysDictValue> selectAll();
    
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysDictValue> entityList);
	
}
