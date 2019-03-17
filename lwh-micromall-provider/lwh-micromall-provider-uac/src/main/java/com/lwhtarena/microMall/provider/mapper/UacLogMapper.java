package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.UacLog;
import com.lwhtarena.microMall.provider.model.dto.log.UacLogMainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Uac log mapper.
 *
 * @author paascloud.net @gmail.com
 */
@Mapper
@Component
public interface UacLogMapper extends MyMapper<UacLog> {
	/**
	 * Select user log list with user id list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<UacLog> selectUserLogListByUserId(@Param("userId") Long userId);

	/**
	 * Query log list with page list.
	 *
	 * @param uacLogQueryDtoPage the uac log query dto page
	 *
	 * @return the list
	 */
	List<UacLog> queryLogListWithPage(UacLogMainDto uacLogQueryDtoPage);
}