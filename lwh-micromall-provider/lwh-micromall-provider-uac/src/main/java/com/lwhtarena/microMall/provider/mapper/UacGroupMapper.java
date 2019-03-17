package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.UacGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Uac group mapper.
 *
 * @author paascloud.net@gmail.com
 */
@Mapper
@Component
public interface UacGroupMapper extends MyMapper<UacGroup> {
}