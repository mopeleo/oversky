package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictValue;
import java.util.List;

public interface SysDictValueDao{

    SysDictValue getById(String unioncode, Long dictcode, String itemcode);

    int deleteById(String unioncode, Long dictcode, String itemcode);

    int updateById(SysDictValue entity);
	
    int dynamicUpdateById(SysDictValue entity);
    
    int count(SysDictValue where);
    
    int insert(SysDictValue entity);

    List<SysDictValue> selectWhere(SysDictValue where);

    List<SysDictValue> selectAll();
    
	int insertBatch(List<SysDictValue> entityList);
	
}
