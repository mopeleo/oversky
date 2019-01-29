package org.oversky.gurms.dao.cust;

import org.oversky.gurms.entity.cust.CustPayAcct;
import java.util.List;

public interface CustPayAcctDao{

    int insert(CustPayAcct entity);

    List<CustPayAcct> selectAll(CustPayAcct where);

    CustPayAcct selectById(Long acctno);

    int deleteById(Long acctno);

    int updateById(CustPayAcct entity);
	
    int dynamicUpdateById(CustPayAcct entity);
}
