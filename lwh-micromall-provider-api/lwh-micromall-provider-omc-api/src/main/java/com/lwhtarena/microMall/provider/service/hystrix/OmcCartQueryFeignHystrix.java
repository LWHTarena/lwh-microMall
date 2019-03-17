package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.vo.CartVo;
import com.lwhtarena.microMall.provider.service.OmcCartQueryFeignApi;
import org.springframework.stereotype.Component;

/**
 * The class Omc cart query feign hystrix.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class OmcCartQueryFeignHystrix implements OmcCartQueryFeignApi {

	@Override
	public Wrapper<CartVo> getCartVo(final Long userId) {
		return null;
	}
}
