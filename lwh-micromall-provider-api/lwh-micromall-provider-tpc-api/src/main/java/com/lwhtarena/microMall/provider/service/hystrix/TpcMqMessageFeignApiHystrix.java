package com.lwhtarena.microMall.provider.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.TpcMqMessageDto;
import com.lwhtarena.microMall.provider.service.TpcMqMessageFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:53
 **/
@Component
@Slf4j
public class TpcMqMessageFeignApiHystrix implements TpcMqMessageFeignApi {

    @Override
    public Wrapper saveMessageWaitingConfirm(final TpcMqMessageDto mqMessageDto) {
        log.error("saveMessageWaitingConfirm - 服务降级. mqMessageDto={}", mqMessageDto);
        return null;
    }

    @Override
    public Wrapper confirmAndSendMessage(final String messageKey) {
        return null;
    }

    @Override
    public Wrapper saveAndSendMessage(final TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public Wrapper directSendMessage(final TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public Wrapper deleteMessageByMessageKey(final String messageKey) {
        return null;
    }

    @Override
    public Wrapper confirmReceiveMessage(final String cid, final String messageKey) {
        return null;
    }

    @Override
    public Wrapper confirmConsumedMessage(final String cid, final String messageKey) {
        return null;
    }
}
