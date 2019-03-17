package com.lwhtarena.microMall.provider.service.impl;


import com.lwhtarena.microMall.common.core.support.BaseService;
import com.lwhtarena.microMall.provider.model.domain.UacUserMenu;
import com.lwhtarena.microMall.provider.service.UacUserMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The class Uac user menu service.
 *
 * @author paascloud.net@gmail.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacUserMenuServiceImpl extends BaseService<UacUserMenu> implements UacUserMenuService {
}
