package org.oversky.gurms.dao.sys;

import org.oversky.gurms.entity.sys.SysUserInfo;
import java.util.List;

public interface SysUserInfoDao{

    int insert(SysUserInfo entity);

    List<SysUserInfo> selectAll(SysUserInfo where);

    SysUserInfo selectById(Long userid);

    int deleteById(Long userid);

    int updateById(SysUserInfo entity);
	
    int dynamicUpdateById(SysUserInfo entity);
}
