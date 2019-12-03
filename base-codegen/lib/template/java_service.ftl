<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Integer<#elseif datatype=="double">Double<#else>Long</#if></#macro>
package ${package};

import org.oversky.base.service.BaseResListDto;
import ${dto_req_package}.${table.code}Req;
import ${dto_res_package}.${table.code}Res;

public interface ${table.code}Service{

	${table.code}Res getById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>);
	
	${table.code}Res delete(${table.code}Req req);

	${table.code}Res insert(${table.code}Req req);
	
	${table.code}Res update(${table.code}Req req);

	BaseResListDto<${table.code}Res> page${table.code}(${table.code}Req req);
}
