package com.lwhtarena.microMall.provider.service;

import com.lwhtarena.microMall.provider.service.hystrix.MdcProductCategoryFeignHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * The interface Mdc product category feign api.
 *
 * @author paascloud.net@gmail.com
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryFeignHystrix.class)
public interface MdcProductCategoryFeignApi {

}
