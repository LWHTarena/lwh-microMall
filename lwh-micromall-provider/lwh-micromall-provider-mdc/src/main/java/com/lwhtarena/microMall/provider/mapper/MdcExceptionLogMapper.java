package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.MdcExceptionLog;
import com.lwhtarena.microMall.provider.model.dto.MdcExceptionQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Mdc exception log mapper.
 *
 * @author paascloud.net @gmail.com
 */
@Mapper
@Component
public interface MdcExceptionLogMapper extends MyMapper<MdcExceptionLog> {
	/**
	 * Query exception list with page list.
	 *
	 * @param mdcExceptionQueryDto the mdc exception query dto
	 *
	 * @return the list
	 */
	List<MdcExceptionLog> queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto);
}