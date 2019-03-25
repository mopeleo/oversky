<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Long<#elseif datatype=="double">Double<#else>Long</#if></#macro>
<#assign enableCache = table.cache&&(param_cache?? && param_cache == 'true')>
package ${package};

import ${java_entity_package}.${table.code};
import java.util.List;

<#if enableCache>
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "${table.code}")
</#if>
public interface ${table.code}Dao{

<#if (table.keys?size > 0)>
	<#if enableCache>@Cacheable(key = "T(${java_entity_package}.${table.code}).buildEntityKey(<#list table.keys as column>#p${column_index}<#if column_has_next>,</#if>)</#list>")</#if>
    ${table.code} getById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>);

	<#if enableCache>@CacheEvict(key = "<#list table.keys as column>'${column.code}:' + #${column.code}<#if column_has_next> + </#if></#list>")</#if>
    int deleteById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>);

	<#if (table.colsExceptKey?size > 0)>
	<#if enableCache>@CacheEvict(key = "<#list table.keys as column>'${column.code}:' + #${column.code}<#if column_has_next> + </#if></#list>")</#if>
    int updateById(${table.code} entity);
	
	<#if enableCache>@CacheEvict(key = "<#list table.keys as column>'${column.code}:' + #${column.code}<#if column_has_next> + </#if></#list>")</#if>
    int dynamicUpdateById(${table.code} entity);
    
	</#if>
</#if>
    int count(${table.code} where);
    
    int insert(${table.code} entity);

	<#if enableCache>@CacheEvict(allEntries=true)</#if>
    int deleteWhere(${table.code} where);

    List<${table.code}> selectWhere(${table.code} where);

	<#if enableCache>@Cacheable(key = "selectAll")</#if>
    List<${table.code}> selectAll();
    
<#if table.keys?size == 1>
	<#if enableCache>@CacheEvict(allEntries=true)</#if>
	int updateBatch(List<${table.code}> entityList);
	
	<#if enableCache>@CacheEvict(allEntries=true)</#if>
	int deleteBatch(<#list table.keys as column><@type datatype=column.datatype /></#list>[] ids);
	
</#if>
<#if ((table.dbms)!'')?contains("MYSQL")>
	int insertBatch(List<${table.code}> entityList);
	
</#if>
}
