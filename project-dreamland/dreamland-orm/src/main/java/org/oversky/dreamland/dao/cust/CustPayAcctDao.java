package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustPayAcct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustPayAcctDao{

	
    CustPayAcct getById(Long acctno);

    int deleteById(Long acctno);

    int updateById(CustPayAcct entity);
	
    int dynamicUpdateById(CustPayAcct entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustPayAcct field, @Param("condition") CustPayAcct where);
    
    int count(CustPayAcct where);
    
	
    int insert(CustPayAcct entity);

	
    int deleteWhere(CustPayAcct where);

    List<CustPayAcct> selectWhere(CustPayAcct where);

	
    List<CustPayAcct> selectAll();
    
	
	int updateBatch(List<CustPayAcct> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustPayAcct> entityList);
	
}
