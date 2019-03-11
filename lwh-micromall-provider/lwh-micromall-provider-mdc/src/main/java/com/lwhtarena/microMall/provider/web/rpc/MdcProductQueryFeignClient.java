package com.lwhtarena.microMall.provider.web.rpc;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Mdc product query feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - MdcProductQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcProductQueryFeignClient extends BaseController implements MdcProductQueryFeignApi {

	@Resource
	private MdcProductService mdcProductService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据商品ID查询商品详细信息")
	public Wrapper<ProductDetailVo> getProductDetail(@PathVariable("productId") Long productId) {
		logger.info("根据商品ID查询商品详细信息. productId={}", productId);
		ProductDetailVo productDto = mdcProductService.getProductDetail(productId);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, productDto);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据商品ID查询商品信息")
	public Wrapper<ProductDto> selectById(@PathVariable("productId") Long productId) {
		logger.info("根据商品ID查询商品信息. productId={}", productId);
		ProductDto productDto = null;
		MdcProduct mdcProduct = mdcProductService.selectByKey(productId);
		if (PublicUtil.isNotEmpty(mdcProduct)) {
			productDto = new ProductDto();
			BeanUtils.copyProperties(mdcProduct, productDto);
		}
		return WrapMapper.ok(productDto);
	}
}
