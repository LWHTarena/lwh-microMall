package com.lwhtarena.microMall.provider.web.rpc;


import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.base.dto.MessageQueryDto;
import com.lwhtarena.microMall.common.base.dto.MqMessageVo;
import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.service.MqMessageService;
import com.lwhtarena.microMall.provider.service.OpcMqMessageFeignApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Mq 消息.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@Api(value = "API - OpcMqMessageFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpcMqMessageFeignClient extends BaseController implements OpcMqMessageFeignApi {
	@Resource
	private MqMessageService mqMessageService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "查询含有的messageKey")
	public Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList) {
		logger.info("查询消息KEY. messageKeyList={}", messageKeyList);
		return WrapMapper.ok(mqMessageService.queryMessageKeyList(messageKeyList));
	}

	@Override
	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto) {
		return mqMessageService.queryMessageListWithPage(messageQueryDto);
	}
}
