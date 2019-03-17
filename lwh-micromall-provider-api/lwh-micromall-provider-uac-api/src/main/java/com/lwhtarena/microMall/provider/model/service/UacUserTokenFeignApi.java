package com.lwhtarena.microMall.provider.model.service;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.service.hystrix.UacUserTokenFeignApiHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:38
 **/

@FeignClient(value = "paascloud-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacUserTokenFeignApiHystrix.class)
public interface UacUserTokenFeignApi {

    /**
     * 超时token更新为离线.
     *
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/token/updateTokenOffLine")
    Wrapper<Integer> updateTokenOffLine();
}
