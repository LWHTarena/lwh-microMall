package com.lwhtarena.microMall.provider.service.hystrix;


import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.base.dto.MessageQueryDto;
import com.lwhtarena.microMall.common.base.dto.MqMessageVo;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.service.MdcMqMessageFeignApi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Mdc mq message api hystrix.
 *
 * @author paascloud.net @gmail.com
 */
@Component
public class MdcMqMessageApiHystrix implements MdcMqMessageFeignApi {
	@Override
	public Wrapper<List<String>> queryMessageKeyList(final List<String> messageKeyList) {
		return null;
	}

	@Override
	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
		return null;
	}
}
