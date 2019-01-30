<#macro type datatype><#if datatype=="string">String<#elseif datatype=="int">Integer<#elseif datatype=="double">Double<#else>Long</#if></#macro>
<#macro type column><#if column.datatype=="string">String<#elseif column.datatype=="int"><#if table.keys?seq_contains(column)>Long<#else>int</#if><#elseif column.datatype=="double"><#if table.keys?seq_contains(column)>Double<#else>double</#if><#else><#if table.keys?seq_contains(column)>Long<#else>long</#if></#if></#macro>
package ${package};

import org.oversky.base.entity.BaseEntity;

public class ${table.code} extends BaseEntity{

	private static final long serialVersionUID = 1L;

<#list table.columns as column>
	private <@type column=column /> ${column.code};    //${column.comment}
</#list>

<#list table.columns as column>
	public <@type column=column /> get${column.code?cap_first}() {
		return this.${column.code};
	}

	public void set${column.code?cap_first}(<@type column=column /> ${column.code}) {
		this.${column.code} = ${column.code};
	}

</#list>
<#if (table.keys?size > 0)>
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("${table.code}");
		return build<#list table.keys as column>.append(this.${column.code})</#list>.toString();
	}

    public static String buildEntityKey(<#list table.keys as column><@type column=column /> ${column.code}<#if column_has_next>, </#if></#list>){
        StringBuilder build = new StringBuilder("${table.code}");
        return build<#list table.keys as column>.append(${column.code})</#list>.toString();
    }
</#if>

<#-- 
    public boolean existId(){
        return <#if (table.keys?size > 0)>true<#else>false</#if>;
    }

	public void clear(){
<#list table.columns as column>
		this.${column.code} = null;
</#list>
	}
 -->	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
<#list table.columns as column>
		sb.append(", ${column.code}=").append(${column.code});
</#list>
        sb.append("]");
        return sb.toString();
	}
}
