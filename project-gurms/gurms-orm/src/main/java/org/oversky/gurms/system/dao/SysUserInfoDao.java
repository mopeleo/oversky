package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserInfo;
import java.util.List;

public interface SysUserInfoDao{

    int insert(SysUserInfo entity);

    List<SysUserInfo> selectWhere(SysUserInfo where);

    List<SysUserInfo> selectAll();

    SysUserInfo selectById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUserInfo entity);
	
    int dynamicUpdateById(SysUserInfo entity);
}
