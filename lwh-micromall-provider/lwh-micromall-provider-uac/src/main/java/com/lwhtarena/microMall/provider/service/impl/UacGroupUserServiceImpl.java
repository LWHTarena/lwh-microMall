package com.lwhtarena.microMall.provider.service.impl;

import com.lwhtarena.microMall.common.core.support.BaseService;
import com.lwhtarena.microMall.provider.mapper.UacGroupUserMapper;
import com.lwhtarena.microMall.provider.model.domain.UacGroup;
import com.lwhtarena.microMall.provider.model.domain.UacGroupUser;
import com.lwhtarena.microMall.provider.service.UacGroupUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Uac group user service.
 *
 * @author paascloud.net@gmail.com
 */
@Service
public class UacGroupUserServiceImpl extends BaseService<UacGroupUser> implements UacGroupUserService {
	@Resource
	private UacGroupUserMapper uacGroupUserMapper;

	@Override
	public UacGroupUser queryByUserId(Long userId) {
		return uacGroupUserMapper.getByUserId(userId);
	}

	@Override
	public int updateByUserId(UacGroupUser uacGroupUser) {
		return uacGroupUserMapper.updateByUserId(uacGroupUser);
	}

	@Override
	public List<UacGroup> getGroupListByUserId(Long userId) {
		return uacGroupUserMapper.selectGroupListByUserId(userId);
	}

	@Override
	public void saveUserGroup(Long userId, Long groupId) {
		UacGroupUser groupUser = new UacGroupUser();
		groupUser.setUserId(userId);
		groupUser.setGroupId(groupId);
		uacGroupUserMapper.insertSelective(groupUser);
	}
}
