package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.UacUserMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Uac user menu mapper.
 *
 * @author paascloud.net@gmail.com
 */
@Mapper
@Component
public interface UacUserMenuMapper extends MyMapper<UacUserMenu> {
}