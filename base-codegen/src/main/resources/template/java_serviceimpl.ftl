<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Integer<#elseif datatype=="double">Double<#else>Long</#if></#macro>
package ${package};

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import ${java_dao_package}.${table.code}Dao;
import ${dto_req_package}.${table.code}Req;
import ${dto_res_package}.${table.code}Res;
import ${java_entity_package}.${table.code};
import ${java_service_package}.${table.code}Service;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

<#assign dao = table.code?uncap_first + "Dao">
<#assign req = table.code?uncap_first + "Req">
@Service
public class ${table.code}ServiceImpl implements ${table.code}Service {
    private static Logger log = LoggerFactory.getLogger(${table.code}ServiceImpl.class);

	@Autowired
	private ${table.code}Dao ${dao};
	@Autowired
	private PageListQueryDao pageQueryDao;
	
	@Override
	public ${table.code}Res getById(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>) {
		${table.code}Res res = new ${table.code}Res();
		${table.code} entity = ${dao}.getById(<#list table.keys as column>${column.code}<#if column_has_next>, </#if></#list>);
		BeanCopyUtils.copy(entity, res);
		res.success();
		return res;
	}

	@Override
	public ${table.code}Res delete(${table.code}Req ${req}) {
		${table.code}Res res = new ${table.code}Res();
		${dao}.deleteById(<#list table.keys as column>${req}.get${column.code?cap_first}()<#if column_has_next>, </#if></#list>);
		res.success();
		return res;
	}

	@Override
	public ${table.code}Res insert(${table.code}Req ${req}) {
		log.info("开始新增......");
		${table.code}Res res = new ${table.code}Res();
		${table.code} entity = BeanCopyUtils.convert(${req}, ${table.code}.class);
		${dao}.insert(entity);
		res.success();
		return res;
	}

	@Override
	public ${table.code}Res update(${table.code}Req ${req}) {
		${table.code}Res res = new ${table.code}Res();
		${table.code} entity = BeanCopyUtils.convert(${req}, ${table.code}.class);
		${dao}.updateById(entity);
		res.success();
		return res;
	}

	@Override
	public BaseResListDto<${table.code}Res> page${table.code}(${table.code}Req ${req}) {
		log.info("开始分页查询，req : {}", ${req}.toString());
		Page<${table.code}Res> page = PageHelper.startPage(${req}.getPageNum(), ${req}.getPageSize());
		${table.code} where = BeanCopyUtils.convert(${req}, ${table.code}.class);
		List<${table.code}> entityList = pageQueryDao.find${table.code}List(where);
		List<${table.code}Res> resList = BeanCopyUtils.convertList(entityList, ${table.code}Res.class);
		
		BaseResListDto<${table.code}Res> resListDto = new BaseResListDto<${table.code}Res>();
		resListDto.setResults(resList);
		resListDto.success("查询成功");
		resListDto.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询结束，共查询到{}条", resList.size());
		return resListDto;
	}
}
