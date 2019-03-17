package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.OrderDto;
import com.lwhtarena.microMall.provider.service.OmcOrderFeignApi;
import org.springframework.stereotype.Component;

/**
 * The class Omc order feign hystrix.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class OmcOrderFeignHystrix implements OmcOrderFeignApi {

	@Override
	public Wrapper updateOrderById(final OrderDto order) {
		return null;
	}
}
