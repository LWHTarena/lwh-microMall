package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.ProductDto;
import com.lwhtarena.microMall.provider.model.vo.ProductDetailVo;
import com.lwhtarena.microMall.provider.service.MdcProductQueryFeignApi;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product query feign hystrix.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class MdcProductQueryFeignHystrix implements MdcProductQueryFeignApi {

	@Override
	public Wrapper<ProductDetailVo> getProductDetail(final Long productId) {
		return null;
	}

	@Override
	public Wrapper<ProductDto> selectById(final Long productId) {
		return null;
	}
}
