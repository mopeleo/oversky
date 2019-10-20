package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustPayLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustPayLogDao{

	
    CustPayLog getById(Long logid);

    int deleteById(Long logid);

    int updateById(CustPayLog entity);
	
    int dynamicUpdateById(CustPayLog entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustPayLog field, @Param("condition") CustPayLog where);
    
    int count(CustPayLog where);
    
	
    int insert(CustPayLog entity);

	
    int deleteWhere(CustPayLog where);

    List<CustPayLog> selectWhere(CustPayLog where);

	
    List<CustPayLog> selectAll();
    
	
	int updateBatch(List<CustPayLog> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustPayLog> entityList);
	
}
