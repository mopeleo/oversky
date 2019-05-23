package org.oversky.gurms.system.ext.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.oversky.gurms.system.entity.SysOrg;

public interface UserOrgDao {

	int countChildOrgUser(List<SysOrg> childOrgs);
	
	int updateUserOrg(@Param("orgid") Long parentOrgId, @Param("children") List<SysOrg> childOrgs);
	
	int deleteByOrgIds(List<SysOrg> Orgs);
}
