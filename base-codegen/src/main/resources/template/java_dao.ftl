<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Long<#elseif datatype=="double">Double<#else>Long</#if></#macro>
package ${package};

import ${java_entity_package}.${table.code};
import java.util.List;

public interface ${table.code}Dao{

<#if (table.keys?size > 0)>
    ${table.code} getById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>);

    int deleteById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>);

	<#if (table.colsExceptKey?size > 0)>
    int updateById(${table.code} entity);
	
    int dynamicUpdateById(${table.code} entity);
    
	</#if>
</#if>
    int count(${table.code} where);
    
    int insert(${table.code} entity);

    List<${table.code}> selectWhere(${table.code} where);

    List<${table.code}> selectAll();
    
<#if table.keys?size == 1>
	int updateBatch(List<${table.code}> entityList);
	
</#if>
<#if ((table.dbms)!'')?contains("MYSQL")>
	int insertBatch(List<${table.code}> entityList);
	
</#if>
}
