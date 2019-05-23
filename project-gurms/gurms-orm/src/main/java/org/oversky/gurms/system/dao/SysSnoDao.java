package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysSno;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSnoDao{

	
    SysSno getById(String unioncode, Integer noid);

    int deleteById(String unioncode, Integer noid);

    int updateById(SysSno entity);
	
    int dynamicUpdateById(SysSno entity);
    
	
    int dynamicUpdateWhere(@Param("field") SysSno field, @Param("condition") SysSno where);
    
    int count(SysSno where);
    
	
    int insert(SysSno entity);

	
    int deleteWhere(SysSno where);

    List<SysSno> selectWhere(SysSno where);

	
    List<SysSno> selectAll();
    
	
	int insertBatch(List<SysSno> entityList);
	
}
