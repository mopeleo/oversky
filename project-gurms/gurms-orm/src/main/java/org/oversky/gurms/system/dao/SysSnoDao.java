package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysSno;
import java.util.List;

public interface SysSnoDao{

	
    SysSno getById(String unioncode, Integer noid);

    int deleteById(String unioncode, Integer noid);

    int updateById(SysSno entity);
	
    int dynamicUpdateById(SysSno entity);
    
    int count(SysSno where);
    
	
    int insert(SysSno entity);

	
    int deleteWhere(SysSno where);

    List<SysSno> selectWhere(SysSno where);

	
    List<SysSno> selectAll();
    
	
	int insertBatch(List<SysSno> entityList);
	
}
