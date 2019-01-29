package org.oversky.gurms.dao.com;

import org.oversky.gurms.entity.com.ComParam;
import java.util.List;

public interface ComParamDao{

    int insert(ComParam entity);

    List<ComParam> selectAll(ComParam where);

    ComParam selectById(String paramid);

    int deleteById(String paramid);

    int updateById(ComParam entity);
	
    int dynamicUpdateById(ComParam entity);
}
