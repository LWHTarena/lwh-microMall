package com.lwhtarena.microMall.provider.model.service.hystrix;

import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.service.UacUserTokenFeignApi;
import org.springframework.stereotype.Component;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:43
 **/
@Component
public class UacUserTokenFeignApiHystrix implements UacUserTokenFeignApi {

    @Override
    public Wrapper<Integer> updateTokenOffLine() {
        return null;
    }
}
