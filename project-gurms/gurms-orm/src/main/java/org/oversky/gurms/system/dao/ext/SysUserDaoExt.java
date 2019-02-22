package org.oversky.gurms.system.dao.ext;

import java.util.List;
import java.util.Map;

public interface SysUserDaoExt {

	List<Map<String, Object>> getUserRole(Map<String, Object> query);
}
