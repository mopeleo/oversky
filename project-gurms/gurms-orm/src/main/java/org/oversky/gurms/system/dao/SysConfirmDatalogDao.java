package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysConfirmDatalog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfirmDatalogDao{

	
    SysConfirmDatalog getById(Long logid);

    int deleteById(Long logid);

    int updateById(SysConfirmDatalog entity);
	
    int dynamicUpdateById(SysConfirmDatalog entity);
    
	
    int dynamicUpdateWhere(@Param("field") SysConfirmDatalog field, @Param("condition") SysConfirmDatalog where);
    
    int count(SysConfirmDatalog where);
    
	
    int insert(SysConfirmDatalog entity);

	
    int deleteWhere(SysConfirmDatalog where);

    List<SysConfirmDatalog> selectWhere(SysConfirmDatalog where);

	
    List<SysConfirmDatalog> selectAll();
    
	
	int updateBatch(List<SysConfirmDatalog> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysConfirmDatalog> entityList);
	
}
