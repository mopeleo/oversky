package org.oversky.gurms.dao.com;

import org.oversky.gurms.entity.com.ComDictValue;
import java.util.List;

public interface ComDictValueDao{

    int insert(ComDictValue entity);

    List<ComDictValue> selectAll(ComDictValue where);

    ComDictValue selectById(Integer dictcode, String itemcode);

    int deleteById(Integer dictcode, String itemcode);

    int updateById(ComDictValue entity);
	
    int dynamicUpdateById(ComDictValue entity);
}
