package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dao.SysRoleDao;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.ext.dao.UniqueCheckDao;
import org.oversky.gurms.system.service.SysRoleService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.valid.GSAValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author Blue
 *
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao roleDao;
	
	@Autowired
	private UniqueCheckDao uniqueDao;
	
	@Override
	@GSAValid(type=SysRoleReq.class)
	public SysRoleRes insert(SysRoleReq roleReq) {
		SysRoleRes res = new SysRoleRes();
		//rolename 唯一性检查
		if(uniqueDao.existRoleName(roleReq.getRolename()) > 0) {
			res.failure("角色名称["+roleReq.getRolename()+"]已存在");
			return res;
		}

		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		if(roleDao.insert(role) == 1) {
			res.success("新增成功");
		}else {
			res.failure("新增失败");
		}
		return res;
	}

	@Override
	public boolean delete(Long roleid) {
		// TODO Auto-generated method stub
		return roleDao.deleteById(roleid) == 1;
	}

	@Override
	public SysRoleRes update(SysRoleReq roleReq) {
		SysRoleRes res = new SysRoleRes();
		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		
		if(roleDao.updateById(role) == 1) {
			res.success("修改成功");
		}else {
			res.failure("修改失败");
		}
		return res;
	}

	@Override
	public SysRoleRes getById(Long roleid) {
		return BeanCopyUtils.convert(roleDao.getById(roleid), SysRoleRes.class);
	}

	@Override
	public BaseResListDto<SysRoleRes> pageSysRole(SysRoleReq roleReq) {
		Page<SysRole> page = PageHelper.startPage(roleReq.getPageNum(), roleReq.getPageSize());
		SysRole where = BeanCopyUtils.convert(roleReq, SysRole.class);
		List<SysRole> roleList = roleDao.selectWhere(where);
		List<SysRoleRes> roleResList = BeanCopyUtils.convertList(roleList, SysRoleRes.class);
		
		BaseResListDto<SysRoleRes> resList = new BaseResListDto<SysRoleRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		return resList;
	}
}
