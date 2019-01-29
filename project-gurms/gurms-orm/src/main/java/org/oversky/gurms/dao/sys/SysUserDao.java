package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysUser;
import java.util.List;

public interface SysUserDao{

    int insert(SysUser entity);

    List<SysUser> selectAll(SysUser where);

    SysUser selectById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUser entity);
	
    int dynamicUpdateById(SysUser entity);
}
