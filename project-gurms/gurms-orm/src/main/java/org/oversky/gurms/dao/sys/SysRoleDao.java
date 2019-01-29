package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysRole;
import java.util.List;

public interface SysRoleDao{

    int insert(SysRole entity);

    List<SysRole> selectAll(SysRole where);

    SysRole selectById(Integer roleid);

    int deleteById(Integer roleid);

    int updateById(SysRole entity);
	
    int dynamicUpdateById(SysRole entity);
}
