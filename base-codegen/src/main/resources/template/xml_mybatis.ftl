<#macro type datatype><#if datatype=="string">VARCHAR<#elseif datatype=="int">INTEGER<#elseif datatype=="double">DOUBLE<#else>DECIMAL</#if></#macro>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${java_dao_package}.${table.code}Dao">
    <resultMap id="BaseResultMap" type="${java_entity_package}.${table.code}">
<#list table.keys as column>
        <id column="${column.originCode}" jdbcType="<@type datatype=column.datatype />" property="${column.code}" />
</#list>
<#list table.columns as column>
	<#if !table.keys?seq_contains(column)>
        <result column="${column.originCode}" jdbcType="<@type datatype=column.datatype />" property="${column.code}" />
	</#if>
</#list>
    </resultMap>

<#if ((table.dbms)!'')?contains("MYSQL") && (table.identityCol??)>    
    <insert id="insert" parameterType="${java_entity_package}.${table.code}" useGeneratedKeys="true" keyProperty="${table.identityCol.code}">
        insert into ${table.originCode?lower_case} (<#list table.columns as column><#if column.identity == "0">${column.originCode}<#if column_has_next>, </#if></#if></#list>)
        values (<#list table.columns as column><#if column.identity == "0">#${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#if></#list>)
    </insert>
<#elseif ((table.dbms)!'')?contains("ORACLE") && (table.identityCol??)>
    <insert id="insert" parameterType="${java_entity_package}.${table.code}">
        insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>)
        values (<#list table.columns as column><#if column.identity == "0">#${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#else>${table.identityCol.sequence}.nextval</#if><#if column_has_next>, </#if></#list>)
    </insert>
<#else>
    <insert id="insert" parameterType="${java_entity_package}.${table.code}">
        insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>)
        values (<#list table.columns as column>#${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#list>)
    </insert>
</#if>
  
<#if ((table.dbms)!'')?contains("MYSQL")>
	<#if table.identityCol??> 
	<insert id="insertBatch" parameterType="java.util.List" useGeneratedKeys="true" keyProperty="${table.identityCol.code}">
		insert into ${table.originCode?lower_case} (<#list table.columns as column><#if column.identity == "0">${column.originCode}<#if column_has_next>, </#if></#if></#list>)
		values 
		<foreach item="item" index="index" collection="list" separator=",">
        (<#list table.columns as column><#if column.identity == "0">#${r'{'}item.${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#if></#list>)
		</foreach>
	</insert>
	<#else>
	<insert id="insertBatch" parameterType="java.util.List" useGeneratedKeys="false">
		insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>) 
		values 
		<foreach item="item" index="index" collection="list" separator=",">
		(<#list table.columns as column>#${r'{'}item.${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#list>)
		</foreach>
	</insert>
	</#if>
<#elseif ((table.dbms)!'')?contains("ORACLE")>
	<#if table.identityCol??> 
	<insert id="insertBatch" parameterType="java.util.List">
		insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>) 
		select ${table.identityCol.sequence}.nextval, t.* from (
		<foreach item="item" index="index" collection="list" separator=" union all ">
			select <#list table.columns as column><#if column.identity == "0">#${r'{'}item.${column.code}} ${column.code}<#if column_has_next>, </#if></#if></#list> from dual
		</foreach>
		) t
	</insert>
	<#else>
	<insert id="insertBatch" parameterType="java.util.List">
		insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>) 
		select t.* from (
		<foreach item="item" index="index" collection="list" separator=" union all ">
			select <#list table.columns as column>#${r'{'}item.${column.code}} ${column.code}<#if column_has_next>, </#if></#list> from dual
		</foreach>
		) t
	</insert>
	</#if>
</#if>
	
    <select id="selectWhere" parameterType="${java_entity_package}.${table.code}" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case} 
          <include refid="where_all_list" />
    </select>

    <delete id="deleteWhere" parameterType="${java_entity_package}.${table.code}">
        delete from ${table.originCode?lower_case} 
          <include refid="where_all_list" />
    </delete>

	<select id="count" resultType="int" parameterType="${java_entity_package}.${table.code}">
        select count(1) from ${table.originCode?lower_case} <include refid="where_all_list" />
	</select>

    <select id="selectAll" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case}
    </select>

<#if (table.keys?size > 0)>
    <select id="getById" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case}
         where <#list table.keys as column>${column.originCode} = #${r'{param'}${column_index+1}}<#if column_has_next> and </#if></#list>
    </select>

    <delete id="deleteById">
        delete from ${table.originCode?lower_case}
         where <#list table.keys as column>${column.originCode} = #${r'{param'}${column_index+1}}<#if column_has_next> and </#if></#list>
    </delete>
  
	<#if (table.colsExceptKey?size > 0)>
    <update id="updateById" parameterType="${java_entity_package}.${table.code}">
        update ${table.originCode?lower_case} set 
		<#list table.colsExceptKey as column>
			<#if column.identity == "0">
               ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if>
			</#if>
		</#list>
		where <#list table.keys as column>${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next> and </#if></#list>
    </update>

	<update id="dynamicUpdateById" parameterType="${java_entity_package}.${table.code}">
		update ${table.originCode?lower_case}
		<set>
		<#list table.colsExceptKey as column>
			<#if column.identity == "0">
		    <if test="${column.code} != null">
				${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />},
		    </if>
		    </#if>
		</#list>
		</set>
		where <#list table.keys as column>${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next> and </#if></#list>
	</update>
	</#if>
</#if>

<#if table.keys?size == 1>
	<update id="updateBatch" parameterType="java.util.List">
	    update ${table.originCode?lower_case}
	    <trim prefix="set" suffixOverrides=",">	
	<#list table.colsExceptKey as column>
		<#if column.identity == "0">
	        <trim prefix="${column.originCode} = case" suffix="end,">
	            <foreach collection="list" item="item" index="index">
	                <if test="item.${column.code} != null">
	                    when <#list table.keys as column>${column.originCode}</#list> = #${r'{'}item.<#list table.keys as column>${column.code}</#list>} then #${r'{'}item.${column.code}, jdbcType=<@type datatype=column.datatype />}
	                </if>
	                <if test="item.${column.code} == null">
	                    when <#list table.keys as column>${column.originCode}</#list> = #${r'{'}item.<#list table.keys as column>${column.code}</#list>} then ${column.originCode}
	                </if>
	            </foreach>
	        </trim>
	    </#if>
	</#list>		
	    </trim>
	    where <#list table.keys as column>${column.originCode}</#list> in
	    <foreach collection="list" index="index" item="item" separator="," open="(" close=")">
	        #${r'{'}item.<#list table.keys as column>${column.code}</#list>}
	    </foreach>
	</update>
	
	<delete id="deleteBatch">
	    delete from ${table.originCode?lower_case}
	     where <#list table.keys as column>${column.originCode}</#list> in
	    <foreach collection="array" item="id" separator="," open="(" close=")">
	        #${r'{'}id}
	    </foreach>
	</delete>
</#if>

	<sql id="column_list">
        <#list table.columns as column>${r'${'}tab}${column.originCode}<#if column_has_next>, </#if></#list>
	</sql>
	
	<sql id="where_all_list">
		<where>
<#list table.columns as column>
			<if test="${column.code} != null<#if column.datatype == "string"> and ${column.code} != ''</#if>">
				and ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}
			</if>
</#list>
		</where>
	</sql>
</mapper>