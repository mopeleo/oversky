package org.oversky.gurms.dao.com;

import org.oversky.gurms.entity.com.ComSerialno;
import java.util.List;

public interface ComSerialnoDao{

    int insert(ComSerialno entity);

    List<ComSerialno> selectAll(ComSerialno where);

    ComSerialno selectById(Integer id);

    int deleteById(Integer id);

    int updateById(ComSerialno entity);
	
    int dynamicUpdateById(ComSerialno entity);
}
