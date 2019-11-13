package org.oversky.dreamland.dao.com;

import org.oversky.dreamland.entity.com.ComDict;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "ComDict")
public interface ComDictDao{

	@Cacheable(key = "T(org.oversky.dreamland.entity.com.ComDict).buildEntityKey(#p0,#p1)", unless = "#result == null")
    ComDict getById(Integer dictcode, String itemcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.dreamland.entity.com.ComDict).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(Integer dictcode, String itemcode);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(ComDict entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(ComDict entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") ComDict field, @Param("condition") ComDict where);
    
    int count(ComDict where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(ComDict entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(ComDict where);

    List<ComDict> selectWhere(ComDict where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<ComDict> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<ComDict> entityList);
	
}
