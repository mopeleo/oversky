package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictIndex;
import java.util.List;

public interface SysDictIndexDao{

    SysDictIndex getById(String unioncode, Long dictcode);

    int deleteById(String unioncode, Long dictcode);

    int updateById(SysDictIndex entity);
	
    int dynamicUpdateById(SysDictIndex entity);
    
    int count(SysDictIndex where);
    
    int insert(SysDictIndex entity);

    int deleteWhere(SysDictIndex where);

    List<SysDictIndex> selectWhere(SysDictIndex where);

    List<SysDictIndex> selectAll();
    
	int insertBatch(List<SysDictIndex> entityList);
	
}
