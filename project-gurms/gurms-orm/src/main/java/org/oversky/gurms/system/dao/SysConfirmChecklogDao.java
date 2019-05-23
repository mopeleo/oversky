package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysConfirmChecklog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfirmChecklogDao{

	
    SysConfirmChecklog getById(Long logid);

    int deleteById(Long logid);

    int updateById(SysConfirmChecklog entity);
	
    int dynamicUpdateById(SysConfirmChecklog entity);
    
	
    int dynamicUpdateWhere(@Param("field") SysConfirmChecklog field, @Param("condition") SysConfirmChecklog where);
    
    int count(SysConfirmChecklog where);
    
	
    int insert(SysConfirmChecklog entity);

	
    int deleteWhere(SysConfirmChecklog where);

    List<SysConfirmChecklog> selectWhere(SysConfirmChecklog where);

	
    List<SysConfirmChecklog> selectAll();
    
	
	int updateBatch(List<SysConfirmChecklog> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<SysConfirmChecklog> entityList);
	
}
