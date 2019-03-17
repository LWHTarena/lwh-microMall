package com.lwhtarena.microMall.provider.service.hystrix;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.ProductCategoryDto;
import com.lwhtarena.microMall.provider.model.dto.ProductReqDto;
import com.lwhtarena.microMall.provider.service.MdcProductCategoryQueryFeignApi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Mdc product category query feign hystrix.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class MdcProductCategoryQueryFeignHystrix implements MdcProductCategoryQueryFeignApi {
	@Override
	public Wrapper<List<ProductCategoryDto>> getProductCategoryData(final Long pid) {
		return null;
	}

	@Override
	public Wrapper<PageInfo> getProductList(final ProductReqDto productReqDto) {
		return null;
	}
}
