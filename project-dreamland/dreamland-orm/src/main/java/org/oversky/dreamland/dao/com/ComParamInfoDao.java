package org.oversky.dreamland.dao.com;

import org.oversky.dreamland.entity.com.ComParamInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@CacheConfig(cacheNames = "ComParamInfo")
public interface ComParamInfoDao{

	@Cacheable(key = "T(org.oversky.dreamland.entity.com.ComParamInfo).buildEntityKey(#p0)", unless = "#result == null")
    ComParamInfo getById(Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "T(org.oversky.dreamland.entity.com.ComParamInfo).buildEntityKey(#p0)", condition = "#result == 1")
	})
    int deleteById(Integer paramid);

	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int updateById(ComParamInfo entity);
	
	@Caching(evict={
		@CacheEvict(key = "'selectAll'", condition = "#result == 1"),
		@CacheEvict(key = "#p0.buildEntityKey()", condition = "#result == 1")
	})
    int dynamicUpdateById(ComParamInfo entity);
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
    int dynamicUpdateWhere(@Param("field") ComParamInfo field, @Param("condition") ComParamInfo where);
    
    int count(ComParamInfo where);
    
	@CacheEvict(key = "'selectAll'", condition = "#result == 1")
    int insert(ComParamInfo entity);

	@CacheEvict(allEntries=true, condition = "#result > 0")
    int deleteWhere(ComParamInfo where);

    List<ComParamInfo> selectWhere(ComParamInfo where);

	@Cacheable(key = "'selectAll'", unless = "#result == null")
    List<ComParamInfo> selectAll();
    
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int updateBatch(List<ComParamInfo> entityList);
	
	@CacheEvict(allEntries=true, condition = "#result > 0")
	int deleteBatch(Integer[] ids);
	
	@CacheEvict(key = "'selectAll'", condition = "#result > 0")
	int insertBatch(List<ComParamInfo> entityList);
	
}
