package org.oversky.gurms.system.dao;

import org.oversky.gurms.system.entity.SysUserInfo;
import java.util.List;

public interface SysUserInfoDao{

    int insert(SysUserInfo entity);

    List<SysUserInfo> selectAll(SysUserInfo where);

    SysUserInfo selectById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUserInfo entity);
	
    int dynamicUpdateById(SysUserInfo entity);
}
