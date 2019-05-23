package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysOrg;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrgDao{

	
    SysOrg getById(Long orgid);

    int deleteById(Long orgid);

    int updateById(SysOrg entity);
	
    int dynamicUpdateById(SysOrg entity);
    
	
    int dynamicUpdateWhere(@Param("field") SysOrg field, @Param("condition") SysOrg where);
    
    int count(SysOrg where);
    
	
    int insert(SysOrg entity);

	
    int deleteWhere(SysOrg where);

    List<SysOrg> selectWhere(SysOrg where);

	
    List<SysOrg> selectAll();
    
	
	int updateBatch(List<SysOrg> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysOrg> entityList);
	
}
