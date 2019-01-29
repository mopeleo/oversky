package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysDictValue;
import java.util.List;

public interface SysDictValueDao{

    int insert(SysDictValue entity);

    List<SysDictValue> selectAll(SysDictValue where);

    SysDictValue selectById(String unioncode, Integer dictcode, String itemcode);

    int deleteById(String unioncode, Integer dictcode, String itemcode);

    int updateById(SysDictValue entity);
	
    int dynamicUpdateById(SysDictValue entity);
}
