package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysMenu;
import java.util.List;

public interface SysMenuDao{

    int insert(SysMenu entity);

    List<SysMenu> selectAll(SysMenu where);

    SysMenu selectById(String menuid);

    int deleteById(String menuid);

    int updateById(SysMenu entity);
	
    int dynamicUpdateById(SysMenu entity);
}
