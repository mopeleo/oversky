package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUser;
import java.util.List;

public interface SysUserDao{

    int insert(SysUser entity);

    List<SysUser> selectWhere(SysUser where);

    List<SysUser> selectAll();

    SysUser selectById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUser entity);
	
    int dynamicUpdateById(SysUser entity);
}
