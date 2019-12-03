<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Integer<#elseif datatype=="double">Double<#else>Long</#if></#macro>
package ${package};

import org.oversky.base.service.BaseResListDto;
import ${dto_req_package}.${table.code}Req;
import ${dto_res_package}.${table.code}Res;
import ${java_service_package}.${table.code}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#assign service = table.code?uncap_first + "Service">
@RestController
@RequestMapping("/${table.code?lower_case}")
public class ${table.code}Controller {
	@Autowired
	private ${table.code}Service ${service};

	@RequestMapping("/detail")
	public ${table.code}Res detail(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>) {
		return ${service}.getById(<#list table.keys as column>${column.code}<#if column_has_next>, </#if></#list>);
	}

	@RequestMapping("/delete")
	public ${table.code}Res delete(@RequestBody ${table.code}Req request) {
		return ${service}.delete(request);
	}

	@RequestMapping("/add")
	public ${table.code}Res add(@RequestBody ${table.code}Req request) {
		return ${service}.insert(request);
	}

	@RequestMapping("/update")
	public ${table.code}Res update(@RequestBody ${table.code}Req request) {
		return ${service}.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<${table.code}Res> page(@RequestBody ${table.code}Req request) {
		return ${service}.page${table.code}(request);
	}
}
