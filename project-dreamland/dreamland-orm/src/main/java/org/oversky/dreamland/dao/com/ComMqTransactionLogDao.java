package org.oversky.dreamland.dao.com;

import org.oversky.dreamland.entity.com.ComMqTransactionLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComMqTransactionLogDao{

	
    ComMqTransactionLog getById(Long logid);

    int deleteById(Long logid);

    int updateById(ComMqTransactionLog entity);
	
    int dynamicUpdateById(ComMqTransactionLog entity);
    
	
    int dynamicUpdateWhere(@Param("field") ComMqTransactionLog field, @Param("condition") ComMqTransactionLog where);
    
    int count(ComMqTransactionLog where);
    
	
    int insert(ComMqTransactionLog entity);

	
    int deleteWhere(ComMqTransactionLog where);

    List<ComMqTransactionLog> selectWhere(ComMqTransactionLog where);

	
    List<ComMqTransactionLog> selectAll();
    
	
	int updateBatch(List<ComMqTransactionLog> entityList);
	
	
	int deleteBatch(Long[] ids);
	
	
	int insertBatch(List<ComMqTransactionLog> entityList);
	
}
