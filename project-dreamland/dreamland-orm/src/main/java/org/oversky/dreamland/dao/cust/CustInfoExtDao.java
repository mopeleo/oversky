package org.oversky.dreamland.dao.cust;

import org.oversky.dreamland.entity.cust.CustInfoExt;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustInfoExtDao{

	
    CustInfoExt getById(Long custno);

    int deleteById(Long custno);

    int updateById(CustInfoExt entity);
	
    int dynamicUpdateById(CustInfoExt entity);
    
	
    int dynamicUpdateWhere(@Param("field") CustInfoExt field, @Param("condition") CustInfoExt where);
    
    int count(CustInfoExt where);
    
	
    int insert(CustInfoExt entity);

	
    int deleteWhere(CustInfoExt where);

    List<CustInfoExt> selectWhere(CustInfoExt where);

	
    List<CustInfoExt> selectAll();
    
	
	int updateBatch(List<CustInfoExt> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<CustInfoExt> entityList);
	
}
