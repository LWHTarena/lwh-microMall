package com.lwhtarena.microMall.provider.service;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.OrderDto;
import com.lwhtarena.microMall.provider.service.hystrix.OmcOrderQueryFeignHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Omc order query feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderQueryFeignHystrix.class)
public interface OmcOrderQueryFeignApi {
	/**
	 * Query by order no wrapper.
	 *
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByOrderNo/{orderNo}")
	Wrapper<OrderDto> queryByOrderNo(@PathVariable("orderNo") String orderNo);

	/**
	 * Query by user id and order no wrapper.
	 *
	 * @param userId  the user id
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByUserIdAndOrderNo/{userId}/{orderNo}")
	Wrapper<OrderDto> queryByUserIdAndOrderNo(@PathVariable("userId") Long userId, @PathVariable("orderNo") String orderNo);
}
