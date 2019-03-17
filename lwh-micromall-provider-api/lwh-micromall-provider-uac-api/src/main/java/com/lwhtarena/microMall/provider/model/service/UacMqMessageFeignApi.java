package com.lwhtarena.microMall.provider.model.service;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.base.dto.MessageQueryDto;
import com.lwhtarena.microMall.common.base.dto.MqMessageVo;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.service.hystrix.UacMqMessageApiHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:39
 **/
@FeignClient(value = "paascloud-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacMqMessageApiHystrix.class)
public interface UacMqMessageFeignApi {

    /**
     * Query waiting confirm message list wrapper.
     *
     * @param messageKeyList the message key list
     *
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/message/queryMessageKeyList")
    Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList);

    /**
     * Query message list with page wrapper.
     *
     * @param messageQueryDto the message query dto
     *
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/message/queryMessageListWithPage")
    Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto);
}
