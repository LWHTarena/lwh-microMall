package com.lwhtarena.microMall.provider.service;


import com.lwhtarena.microMall.common.core.support.IService;
import com.lwhtarena.microMall.provider.model.domain.UacRoleMenu;

import java.util.List;
import java.util.Set;


/**
 * The interface Uac role menu service.
 *
 * @author paascloud.net @gmail.com
 */
public interface UacRoleMenuService extends IService<UacRoleMenu> {
	/**
	 * Del role menu list int.
	 *
	 * @param uacRoleMenus the uac role menus
	 *
	 * @return the int
	 */
	int delRoleMenuList(Set<UacRoleMenu> uacRoleMenus);

	/**
	 * Delete by role id.
	 *
	 * @param roleId the role id
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * List by role id list.
	 *
	 * @param roleId the role id
	 *
	 * @return the list
	 */
	List<UacRoleMenu> listByRoleId(Long roleId);

	/**
	 * Insert.
	 *
	 * @param roleId     the role id
	 * @param menuIdList the menu id list
	 */
	void insert(Long roleId, Set<Long> menuIdList);

	/**
	 * Delete by role id list.
	 *
	 * @param roleIdList the role id list
	 */
	void deleteByRoleIdList(List<Long> roleIdList);
}
