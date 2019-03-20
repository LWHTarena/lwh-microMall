package com.lwhtarena.microMall.provider.web.rpc;

import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.vo.CartVo;
import com.lwhtarena.microMall.provider.service.OmcCartQueryFeignApi;
import com.lwhtarena.microMall.provider.service.OmcCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Mall cart query feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - MallCartQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MallCartQueryFeignClient extends BaseController implements OmcCartQueryFeignApi {

	@Resource
	private OmcCartService omcCartService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "获取购物车信息")
	public Wrapper<CartVo> getCartVo(@RequestParam("userId") Long userId) {
		logger.info("getCartVo - 获取购物车信息. userId={}", userId);
		CartVo cartVo = omcCartService.getCarVo(userId);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, cartVo);
	}
}
