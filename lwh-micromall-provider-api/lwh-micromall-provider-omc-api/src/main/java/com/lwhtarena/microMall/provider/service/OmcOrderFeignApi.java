package com.lwhtarena.microMall.provider.service;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.OrderDto;
import com.lwhtarena.microMall.provider.service.hystrix.OmcOrderFeignHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Omc order feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderFeignHystrix.class)
public interface OmcOrderFeignApi {
	/**
	 * Update order by id wrapper.
	 *
	 * @param order the order
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/updateOrderById")
	Wrapper updateOrderById(@RequestBody OrderDto order);
}
