package com.lwhtarena.microMall.provider.service;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.util.annotation.NoNeedAccessAuthentication;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.ProductCategoryDto;
import com.lwhtarena.microMall.provider.model.dto.ProductReqDto;
import com.lwhtarena.microMall.provider.service.hystrix.MdcProductCategoryQueryFeignHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * The interface Mdc product category query feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryQueryFeignHystrix.class)
public interface MdcProductCategoryQueryFeignApi {

	/**
	 * 查询分类信息.
	 *
	 * @param pid the pid
	 *
	 * @return the product category data
	 */
	@PostMapping(value = "/api/productCategory/getProductCategoryDtoByPid/{pid}")
	@NoNeedAccessAuthentication
	Wrapper<List<ProductCategoryDto>> getProductCategoryData(@PathVariable("pid") Long pid);

	/**
	 * 查询商品列表.
	 *
	 * @param productReqDto the product req dto
	 *
	 * @return the product list
	 */
	@PostMapping(value = "/api/product/getProductList")
	@NoNeedAccessAuthentication
	Wrapper<PageInfo> getProductList(@RequestBody ProductReqDto productReqDto);

}
