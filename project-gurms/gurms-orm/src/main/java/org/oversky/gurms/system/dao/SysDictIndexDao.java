package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictIndex;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "SysDictIndex")
public interface SysDictIndexDao{

	@Cacheable(key = "T(org.oversky.gurms.system.entity.SysDictIndex).buildEntityKey(#p0,)#p1)", unless = "#result == null")
    SysDictIndex getById(String unioncode, Long dictcode);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode")
    int deleteById(String unioncode, Long dictcode);

	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode")
    int updateById(SysDictIndex entity);
	
	@CacheEvict(key = "'unioncode:' + #unioncode + 'dictcode:' + #dictcode")
    int dynamicUpdateById(SysDictIndex entity);
    
    int count(SysDictIndex where);
    
	@CacheEvict(key = "selectAll", condition = "#result == 1")
    int insert(SysDictIndex entity);

	@CacheEvict(allEntries=true)
    int deleteWhere(SysDictIndex where);

    List<SysDictIndex> selectWhere(SysDictIndex where);

	@Cacheable(key = "selectAll", unless = "#result == null")
    List<SysDictIndex> selectAll();
    
	@CacheEvict(key = "selectAll", condition = "#result > 0")
	int insertBatch(List<SysDictIndex> entityList);
	
}
