package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.GlobalExceptionLogDto;
import com.lwhtarena.microMall.provider.service.MdcExceptionLogFeignApi;
import org.springframework.stereotype.Component;


/**
 * The class Mdc exception log feign hystrix.
 *
 * @author paascloud.net @gmail.com
 */
@Component
public class MdcExceptionLogFeignHystrix implements MdcExceptionLogFeignApi {

	@Override
	public Wrapper saveAndSendExceptionLog(final GlobalExceptionLogDto exceptionLogDto) {
		return null;
	}
}
