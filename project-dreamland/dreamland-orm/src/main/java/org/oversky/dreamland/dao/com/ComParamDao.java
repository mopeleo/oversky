package org.oversky.dreamland.dao.com;

import org.oversky.dreamland.entity.com.ComParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "ComParam")
public interface ComParamDao{

	@Cacheable(key = "T(org.oversky.dreamland.entity.com.ComParam).buildEntityKey(#p0,#p1)", unless = "#result == null")
    ComParam getById(String unioncode, Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.dreamland.entity.com.ComParam).buildEntityKey(#p0,#p1)", condition = "#result == 1")
	})
    int deleteById(String unioncode, Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(ComParam entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(ComParam entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") ComParam field, @Param("condition") ComParam where);
    
    int count(ComParam where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(ComParam entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(ComParam where);

    List<ComParam> selectWhere(ComParam where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<ComParam> selectAll();
    
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<ComParam> entityList);
	
}
