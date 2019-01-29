package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysMenu;
import java.util.List;

public interface SysMenuDao{

    int insert(SysMenu entity);

    List<SysMenu> selectAll(SysMenu where);

    SysMenu selectById(String menuid);

    int deleteById(String menuid);

    int updateById(SysMenu entity);
	
    int dynamicUpdateById(SysMenu entity);
}
