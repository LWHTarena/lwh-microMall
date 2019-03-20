package com.lwhtarena.microMall.provider.web.rpc;


import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.provider.service.OmcOrderDetailFeignApi;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * The class Omc order detail feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - OmcOrderDetailFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderDetailFeignClient extends BaseController implements OmcOrderDetailFeignApi {

}
