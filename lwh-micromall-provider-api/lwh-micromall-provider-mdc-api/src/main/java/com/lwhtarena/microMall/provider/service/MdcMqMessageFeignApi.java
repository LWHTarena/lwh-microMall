package com.lwhtarena.microMall.provider.service;


import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.base.dto.MessageQueryDto;
import com.lwhtarena.microMall.common.base.dto.MqMessageVo;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.service.hystrix.MdcMqMessageApiHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Mdc mq message feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcMqMessageApiHystrix.class)
public interface MdcMqMessageFeignApi {


	/**
	 * Query waiting confirm message list wrapper.
	 *
	 * @param messageKeyList the message key list
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/mdc/message/queryMessageKeyList")
	Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList);

	/**
	 * Query message list with page wrapper.
	 *
	 * @param messageQueryDto the message query dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/mdc/message/queryMessageListWithPage")
	Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto);
}
