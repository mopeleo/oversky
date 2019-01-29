package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysDictIndex;
import java.util.List;

public interface SysDictIndexDao{

    int insert(SysDictIndex entity);

    List<SysDictIndex> selectAll(SysDictIndex where);

    SysDictIndex selectById(String unioncode, Integer dictcode);

    int deleteById(String unioncode, Integer dictcode);

    int updateById(SysDictIndex entity);
	
    int dynamicUpdateById(SysDictIndex entity);
}
