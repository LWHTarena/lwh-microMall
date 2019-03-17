package com.lwhtarena.microMall.provider.service;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.GlobalExceptionLogDto;
import com.lwhtarena.microMall.provider.service.hystrix.MdcExceptionLogFeignHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Mdc product feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcExceptionLogFeignHystrix.class)
public interface MdcExceptionLogFeignApi {

	/**
	 * Update product stock by id int.
	 *
	 * @param exceptionLogDto the exception log dto
	 *
	 * @return the int
	 */
	@PostMapping(value = "/api/exception/saveAndSendExceptionLog")
	Wrapper saveAndSendExceptionLog(@RequestBody GlobalExceptionLogDto exceptionLogDto);
}
