package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictIndex;
import java.util.List;

public interface SysDictIndexDao{

    int insert(SysDictIndex entity);

    List<SysDictIndex> selectAll(SysDictIndex where);

    SysDictIndex selectById(String unioncode, Integer dictcode);

    int deleteById(String unioncode, Integer dictcode);

    int updateById(SysDictIndex entity);
	
    int dynamicUpdateById(SysDictIndex entity);
}
