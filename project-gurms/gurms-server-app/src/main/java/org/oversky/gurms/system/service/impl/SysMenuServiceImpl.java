package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oversky.base.util.BeanCopyUtils;
import org.oversky.gurms.system.dao.SysMenuDao;
import org.oversky.gurms.system.dao.ext.SysUserDaoExt;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao menuDao;
	
	@Autowired
	private SysUserDaoExt userDaoExt;
	
	@Override
	public SysMenuRes getMenu(String menuId, boolean tree) {
		SysMenuRes res = new SysMenuRes();
		SysMenu menu = menuDao.getById(menuId);
		if(menu == null) {
			res.failure("menuId不存在:" + menuId);
		}else {
			BeanCopyUtils.copy(menu, res);
			res.setTree(tree);
		}
		if(tree) {
			this.getSubMenus(res);
		}
		return res;
	}


	@Override
	public boolean isCorrectUrl(String url) {
		List<SysMenu> menus = menuDao.selectAll();
		for(SysMenu menu : menus) {
			if(url.endsWith(menu.getMenuurl())) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public SysMenuRes getMenuByUrl(String url) {
		// TODO Auto-generated method stub
		SysMenu menu = new SysMenu();
		menu.setMenuurl(url);
		List<SysMenu> menus = menuDao.selectWhere(menu);
		SysMenuRes res = null;
		if(menus != null && menus.size() > 0) {
			menu = menus.get(0);
			res = new SysMenuRes();
			BeanCopyUtils.copy(menu, res);
		}
		return res;
	}

	@Override
	public SysMenuRes getUserMenuTree(Long userId) {
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userDaoExt.getUserMenus(userId);
		this.createMenuTree(root, userMenus);
		return root;
	}

	@Override
	public SysMenuRes getRoleMenuTree(Long roleId) {
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userDaoExt.getRoleMenus(roleId);
		this.createMenuTree(root, userMenus);
		return root;
	}
	
	private void getSubMenus(SysMenuRes menuRes) {
		List<SysMenu> children = userDaoExt.getSubMenus(menuRes.getMenuid());
		if(children != null && children.size() > 0) {
			List<SysMenuRes> childrenRes = BeanCopyUtils.convertList(children, SysMenuRes.class);
			menuRes.setSubMenus(childrenRes);
			menuRes.setTree(true);
			for(SysMenuRes child : childrenRes) {
				//是目录，继续向下查询
				if(child.getMenutype() == 0) {
					getSubMenus(child);
				}
			}
		}
	}
	
	private void createMenuTree(SysMenuRes root, List<SysMenu> existList){
		if(root.getSubMenus() == null) {
			return;
		}
		Iterator<SysMenuRes> it = root.getSubMenus().iterator();
		List<String> menuIdList = new ArrayList<String>(existList.size());
		for(SysMenu menu : existList) {
			menuIdList.add(menu.getMenuid());
		}
		while(it.hasNext()){
			SysMenuRes menuRes = it.next();
			if(menuIdList.contains(menuRes.getMenuid())) {
				createMenuTree(menuRes, existList);
			}else {
				it.remove();				
			}
		}
	}

}
