package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustLogLogin;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustLogLoginDao{

	
    CustLogLogin getById(Long logid);

    int deleteById(Long logid);

    int updateById(CustLogLogin entity);
	
    int dynamicUpdateById(CustLogLogin entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustLogLogin field, @Param("condition") CustLogLogin where);
    
    int count(CustLogLogin where);
    
	
    int insert(CustLogLogin entity);

	
    int deleteWhere(CustLogLogin where);

    List<CustLogLogin> selectWhere(CustLogLogin where);

	
    List<CustLogLogin> selectAll();
    
	
	int updateBatch(List<CustLogLogin> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustLogLogin> entityList);
	
}
