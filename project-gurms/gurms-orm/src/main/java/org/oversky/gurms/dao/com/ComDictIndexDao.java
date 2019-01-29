package org.oversky.gurms.dao.com;

import org.oversky.gurms.entity.com.ComDictIndex;
import java.util.List;

public interface ComDictIndexDao{

    int insert(ComDictIndex entity);

    List<ComDictIndex> selectAll(ComDictIndex where);

    ComDictIndex selectById(Integer dictcode);

    int deleteById(Integer dictcode);

    int updateById(ComDictIndex entity);
	
    int dynamicUpdateById(ComDictIndex entity);
}
