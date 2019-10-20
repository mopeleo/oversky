package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustInfoDao{

	
    CustInfo getById(Long custno);

    int deleteById(Long custno);

    int updateById(CustInfo entity);
	
    int dynamicUpdateById(CustInfo entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustInfo field, @Param("condition") CustInfo where);
    
    int count(CustInfo where);
    
	
    int insert(CustInfo entity);

	
    int deleteWhere(CustInfo where);

    List<CustInfo> selectWhere(CustInfo where);

	
    List<CustInfo> selectAll();
    
	
	int updateBatch(List<CustInfo> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustInfo> entityList);
	
}
