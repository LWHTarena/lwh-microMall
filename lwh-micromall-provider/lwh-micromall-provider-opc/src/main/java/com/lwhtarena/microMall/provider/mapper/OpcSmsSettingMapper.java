package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.OpcSmsSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Opc sms setting mapper.
 *
 * @author paascloud.net@gmail.com
 */
@Mapper
@Component
public interface OpcSmsSettingMapper extends MyMapper<OpcSmsSetting> {
}