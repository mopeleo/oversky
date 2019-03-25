package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysMenu;
import java.util.List;

public interface SysMenuDao{

	
    SysMenu getById(String menuid);

	
    int deleteById(String menuid);

	
    int updateById(SysMenu entity);
	
	
    int dynamicUpdateById(SysMenu entity);
    
    int count(SysMenu where);
    
    int insert(SysMenu entity);

	
    int deleteWhere(SysMenu where);

    List<SysMenu> selectWhere(SysMenu where);

	
    List<SysMenu> selectAll();
    
	
	int updateBatch(List<SysMenu> entityList);
	
	
	int deleteBatch(String[] ids);
	
	int insertBatch(List<SysMenu> entityList);
	
}
