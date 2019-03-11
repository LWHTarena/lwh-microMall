package com.lwhtarena.microMall.provider.web.rpc;

import io.swagger.annotations.Api;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class Mdc product category feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - MdcProductCategoryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcProductCategoryFeignClient extends BaseController implements MdcProductCategoryFeignApi {
}
