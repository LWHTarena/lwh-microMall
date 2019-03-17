package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.OrderDto;
import com.lwhtarena.microMall.provider.service.OmcOrderQueryFeignApi;
import org.springframework.stereotype.Component;

/**
 * The class Omc order query feign hystrix.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class OmcOrderQueryFeignHystrix implements OmcOrderQueryFeignApi {


	@Override
	public Wrapper<OrderDto> queryByOrderNo(final String orderNo) {
		return null;
	}

	@Override
	public Wrapper<OrderDto> queryByUserIdAndOrderNo(final Long userId, final String orderNo) {
		return null;
	}
}
