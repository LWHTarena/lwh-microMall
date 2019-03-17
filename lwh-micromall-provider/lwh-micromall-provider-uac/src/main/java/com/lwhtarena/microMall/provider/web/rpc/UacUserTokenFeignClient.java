package com.lwhtarena.microMall.provider.web.rpc;

import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.service.UacUserTokenFeignApi;
import com.lwhtarena.microMall.provider.service.UacUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 用户token.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@Api(value = "API - UacUserTokenFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacUserTokenFeignClient extends BaseController implements UacUserTokenFeignApi {
	@Resource
	private UacUserTokenService uacUserTokenService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "更新token离线状态")
	public Wrapper<Integer> updateTokenOffLine() {
		int result = uacUserTokenService.batchUpdateTokenOffLine();
		return handleResult(result);
	}
}
