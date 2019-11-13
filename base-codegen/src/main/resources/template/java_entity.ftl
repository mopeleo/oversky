<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Integer<#elseif datatype=="double">Double<#else>Long</#if></#macro>
<#-- 
<#macro type column><#if column.datatype=="string">String<#elseif column.datatype=="int"><#if table.keys?seq_contains(column)>Long<#else>int</#if><#elseif column.datatype=="double"><#if table.keys?seq_contains(column)>Double<#else>double</#if><#else><#if table.keys?seq_contains(column)>Long<#else>long</#if></#if></#macro>
 -->
package ${package};

import org.oversky.base.entity.BaseEntity;

public class ${table.code} extends BaseEntity{

	private static final long serialVersionUID = 1L;

<#list table.columns as column>
	private <@type datatype=column.datatype /> ${column.code};    //${column.comment}
</#list>

<#list table.columns as column>
	public <@type datatype=column.datatype /> get${column.code?cap_first}() {
		return this.${column.code};
	}

	public void set${column.code?cap_first}(<@type datatype=column.datatype /> ${column.code}) {
		this.${column.code} = ${column.code};
	}

</#list>
<#if (table.keys?size > 0)>
	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("${table.code}");
		return build<#list table.keys as column>.append("#${column.code}:").append(this.${column.code})</#list>.toString();
	}

    public static String buildEntityKey(<#list table.keys as column><@type datatype=column.datatype /> ${column.code}<#if column_has_next>, </#if></#list>){
        StringBuilder build = new StringBuilder("${table.code}");
        return build<#list table.keys as column>.append("#${column.code}:").append(${column.code})</#list>.toString();
    }
    
    public void copyPrimaryKey(${table.code} entity){
	<#list table.keys as column>
		this.${column.code} = entity.get${column.code?cap_first}();
	</#list>    	
    }
</#if>

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
<#list table.columns as column>
		sb.append("${column.code}=").append(${column.code}).append(", ");
</#list>
        sb.append(super.toString());
        return sb.toString();
	}
}
