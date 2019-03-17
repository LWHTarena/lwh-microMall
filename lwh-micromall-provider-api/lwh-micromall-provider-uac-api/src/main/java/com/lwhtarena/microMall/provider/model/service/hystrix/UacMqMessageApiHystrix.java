package com.lwhtarena.microMall.provider.model.service.hystrix;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.base.dto.MessageQueryDto;
import com.lwhtarena.microMall.common.base.dto.MqMessageVo;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.service.UacMqMessageFeignApi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:42
 **/
@Component
public class UacMqMessageApiHystrix implements UacMqMessageFeignApi {


    public Wrapper<List<String>> queryMessageKeyList(final List<String> messageKeyList) {
        return null;
    }

    @Override
    public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
        return null;
    }
}
