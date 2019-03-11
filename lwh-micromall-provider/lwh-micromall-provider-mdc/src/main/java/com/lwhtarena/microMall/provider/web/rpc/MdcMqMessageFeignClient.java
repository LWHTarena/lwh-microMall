package com.lwhtarena.microMall.provider.web.rpc;



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
@Api(value = "API - MdcMqMessageFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcMqMessageFeignClient extends BaseController implements MdcMqMessageFeignApi {
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
