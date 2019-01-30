package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictIndex;
import java.util.List;

public interface SysDictIndexDao{

    int insert(SysDictIndex entity);

    List<SysDictIndex> selectWhere(SysDictIndex where);

    List<SysDictIndex> selectAll();

    SysDictIndex selectById(String unioncode, Long dictcode);

    int deleteById(String unioncode, Long dictcode);

    int updateById(SysDictIndex entity);
	
    int dynamicUpdateById(SysDictIndex entity);
}
