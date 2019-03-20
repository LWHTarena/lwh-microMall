package com.lwhtarena.microMall.provider.service;


import com.lwhtarena.microMall.common.core.support.IService;
import com.lwhtarena.microMall.provider.model.domain.UacGroup;
import com.lwhtarena.microMall.provider.model.domain.UacGroupUser;

import java.util.List;


/**
 * The interface Uac group user service.
 *
 * @author paascloud.net@gmail.com
 */
public interface UacGroupUserService extends IService<UacGroupUser> {
	/**
	 * 根据userId查询
	 *
	 * @param userId the user id
	 *
	 * @return the uac group user
	 */
	UacGroupUser queryByUserId(Long userId);

	/**
	 * 根据userId和version修改
	 *
	 * @param uacGroupUser the uac group user
	 *
	 * @return the int
	 */
	int updateByUserId(UacGroupUser uacGroupUser);

	/**
	 * 通过用户Id获取组织信息
	 *
	 * @param userId the user id
	 *
	 * @return the group list by user id
	 */
	List<UacGroup> getGroupListByUserId(Long userId);

	/**
	 * Save user group.
	 *
	 * @param id      the id
	 * @param groupId the group id
	 */
	void saveUserGroup(Long id, Long groupId);
}