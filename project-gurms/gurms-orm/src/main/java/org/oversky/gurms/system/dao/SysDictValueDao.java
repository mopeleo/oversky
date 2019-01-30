package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysDictValue;
import java.util.List;

public interface SysDictValueDao{

    int insert(SysDictValue entity);

    List<SysDictValue> selectWhere(SysDictValue where);

    List<SysDictValue> selectAll();

    SysDictValue selectById(String unioncode, Long dictcode, String itemcode);

    int deleteById(String unioncode, Long dictcode, String itemcode);

    int updateById(SysDictValue entity);
	
    int dynamicUpdateById(SysDictValue entity);
}
