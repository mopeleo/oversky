package org.oversky.gurms.dao.cust;

import org.oversky.gurms.entity.cust.CustInfoExt;
import java.util.List;

public interface CustInfoExtDao{

    int insert(CustInfoExt entity);

    List<CustInfoExt> selectAll(CustInfoExt where);

    CustInfoExt selectById(Long custno);

    int deleteById(Long custno);

    int updateById(CustInfoExt entity);
	
    int dynamicUpdateById(CustInfoExt entity);
}
