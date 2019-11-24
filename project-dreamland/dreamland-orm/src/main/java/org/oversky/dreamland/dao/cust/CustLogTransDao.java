package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustLogTrans;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustLogTransDao{

	
    CustLogTrans getById(Long logid);

    int deleteById(Long logid);

    int updateById(CustLogTrans entity);
	
    int dynamicUpdateById(CustLogTrans entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustLogTrans field, @Param("condition") CustLogTrans where);
    
    int count(CustLogTrans where);
    
	
    int insert(CustLogTrans entity);

	
    int deleteWhere(CustLogTrans where);

    List<CustLogTrans> selectWhere(CustLogTrans where);

	
    List<CustLogTrans> selectAll();
    
	
	int updateBatch(List<CustLogTrans> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustLogTrans> entityList);
	
}
