package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dao.SysMenuDao;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.ext.dao.UserRightDao;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "SysMenu")
public class SysMenuServiceImpl implements SysMenuService {

	private static final Logger log = LoggerFactory.getLogger(SysMenuServiceImpl.class);

	@Autowired
	private SysMenuDao menuDao;
	
	@Autowired
	private UserRightDao userRightDao;
	
	@Override
	public SysMenuRes getMenu(String menuId, boolean tree) {
		log.info("开始查询菜单[menuId={}, tree={}]信息...", menuId, tree);
		SysMenuRes res = new SysMenuRes();
		SysMenu menu = menuDao.getById(menuId);
		if(menu == null) {
			res.failure("menuId不存在:" + menuId);
			log.warn(res.getReturnmsg());
			return res;
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
	@Cacheable(key = "'getFullMenuTree'")
	public SysMenuRes getFullMenuTree() {
		log.info("开始查询整个菜单树信息...");
		SysMenuRes root = new SysMenuRes();
		getSubMenus(root);
		return root;
	}
	
	@Override
	@Cacheable(key = "'getMenuByUrl-' + #p0")
	public SysMenuRes getMenuByUrl(String url) {
		log.info("根据url={}查找菜单...", url);
		SysMenu menu = new SysMenu();
		menu.setMenuurl(url);
		menu.setStatus(DictConsts.DICT1003_VALID);
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
		log.info("查找用户[userid={}]的菜单树...", userId);
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userRightDao.getUserMenus(userId);
		this.createMenuTree(root, userMenus);
		return root;
	}

	@Override
	public SysMenuRes getRoleMenuTree(Long roleId) {
		log.info("查找角色[roleId={}]的菜单树...", roleId);
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userRightDao.getRoleMenus(roleId);
		this.createMenuTree(root, userMenus);
		return root;
	}
	
	private void getSubMenus(SysMenuRes menuRes) {
		List<SysMenu> children = userRightDao.getSubMenus(menuRes.getMenuid());
		if(children != null && children.size() > 0) {
			List<SysMenuRes> childrenRes = BeanCopyUtils.convertList(children, SysMenuRes.class);
			if(menuRes.getMenutype() == null) {
				menuRes.setMenutype(DictConsts.DICT2010_MENYTYPE_DIRECTORY);
			}
			menuRes.setSubMenus(childrenRes);
			menuRes.setTree(true);
			for(SysMenuRes child : childrenRes) {
				//不是按钮，继续向下查询
				if(!DictConsts.DICT2010_MENYTYPE_ELEMENT.equals(child.getMenutype())) {
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
