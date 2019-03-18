package com.lwhtarena.microMall.provider.service;


import com.lwhtarena.microMall.common.util.annotation.NoNeedAccessAuthentication;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.robot.ChatRobotMsgDto;
import com.lwhtarena.microMall.provider.service.hystrix.DingtalkFeignApiHystrix;
import com.lwhtarena.microMall.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Dingtalk feign api.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-opc", configuration = OAuth2FeignAutoConfiguration.class, fallback = DingtalkFeignApiHystrix.class)
public interface DingtalkFeignApi {

	/**
	 * 钉钉机器人推送消息.
	 *
	 * @param uacUserReqDto the uac user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/opc/dingtalk/sendChatRobotMsg")
	@NoNeedAccessAuthentication
	Wrapper<Boolean> sendChatRobotMsg(@RequestBody ChatRobotMsgDto uacUserReqDto);
}
