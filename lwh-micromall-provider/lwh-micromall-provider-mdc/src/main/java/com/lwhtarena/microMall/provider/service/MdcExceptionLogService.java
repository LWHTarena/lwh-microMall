package com.lwhtarena.microMall.provider.service;


import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.core.support.IService;
import com.lwhtarena.microMall.provider.model.domain.MdcExceptionLog;
import com.lwhtarena.microMall.provider.model.dto.MdcExceptionQueryDto;


/**
 * The interface Mdc exception log service.
 *
 * @author paascloud.net @gmail.com
 */
public interface MdcExceptionLogService extends IService<MdcExceptionLog> {
	/**
	 * 保存日志并发送钉钉消息.
	 *
	 * @param exceptionLogDto the exception log dto
	 */
	void saveAndSendExceptionLog(GlobalExceptionLogDto exceptionLogDto);

	/**
	 * Query exception list with page page info.
	 *
	 * @param mdcExceptionQueryDto the mdc exception query dto
	 *
	 * @return the page info
	 */
	PageInfo queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto);
}
