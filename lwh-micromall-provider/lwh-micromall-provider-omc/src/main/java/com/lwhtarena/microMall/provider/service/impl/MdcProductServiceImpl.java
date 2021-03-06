package com.lwhtarena.microMall.provider.service.impl;


import com.google.common.base.Preconditions;
import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.exceptions.MdcBizException;
import com.lwhtarena.microMall.provider.model.dto.ProductDto;
import com.lwhtarena.microMall.provider.model.vo.ProductDetailVo;
import com.lwhtarena.microMall.provider.service.MdcProductFeignApi;
import com.lwhtarena.microMall.provider.service.MdcProductQueryFeignApi;
import com.lwhtarena.microMall.provider.service.MdcProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The class Mdc product service.
 *
 * @author paascloud.net@gmail.com
 */
@Slf4j
@Service
public class MdcProductServiceImpl implements MdcProductService {
	@Resource
	private MdcProductQueryFeignApi mdcProductQueryFeignApi;
	@Resource
	private MdcProductFeignApi mdcProductFeignApi;

	@Override
	public ProductDto selectById(Long productId) {
		log.info("查询商品信息. productId={}", productId);
		Preconditions.checkArgument(productId != null, ErrorCodeEnum.MDC10021021.msg());
		Wrapper<ProductDto> productDtoWrapper = mdcProductQueryFeignApi.selectById(productId);

		if (productDtoWrapper == null) {
			throw new MdcBizException(ErrorCodeEnum.MDC10021003);
		}
		if (productDtoWrapper.error()) {
			throw new MdcBizException(ErrorCodeEnum.MDC10021004, productId);
		}
		return productDtoWrapper.getResult();

	}

	@Override
	public ProductDetailVo getProductDetail(Long productId) {
		log.info("获取商品详情. productId={}", productId);
		Preconditions.checkArgument(productId != null, ErrorCodeEnum.MDC10021021.msg());

		Wrapper<ProductDetailVo> wrapper = mdcProductQueryFeignApi.getProductDetail(productId);

		if (wrapper == null) {
			throw new MdcBizException(ErrorCodeEnum.GL99990002);
		}
		if (wrapper.error()) {
			throw new MdcBizException(ErrorCodeEnum.MDC10021004, productId);
		}
		return wrapper.getResult();
	}

	@Override
	public int updateProductStockById(ProductDto productDto) {
		Preconditions.checkArgument(productDto.getId() != null, ErrorCodeEnum.MDC10021021.msg());
		Wrapper<Integer> wrapper = mdcProductFeignApi.updateProductStockById(productDto);
		if (wrapper == null) {
			throw new MdcBizException(ErrorCodeEnum.GL99990002);
		}
		if (wrapper.error()) {
			throw new MdcBizException(ErrorCodeEnum.MDC10021022, productDto.getId());
		}
		return wrapper.getResult();
	}

	@Override
	public String getMainImage(final Long productId) {
		Wrapper<String> wrapper = mdcProductFeignApi.getMainImage(productId);
		if (wrapper == null) {
			throw new MdcBizException(ErrorCodeEnum.GL99990002);
		}
		return wrapper.getResult();
	}
}
