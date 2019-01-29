package org.oversky.gurms.dao.cust;

import org.oversky.gurms.entity.cust.CustInfo;
import java.util.List;

public interface CustInfoDao{

    int insert(CustInfo entity);

    List<CustInfo> selectAll(CustInfo where);

    CustInfo selectById(Long custno);

    int deleteById(Long custno);

    int updateById(CustInfo entity);
	
    int dynamicUpdateById(CustInfo entity);
}
