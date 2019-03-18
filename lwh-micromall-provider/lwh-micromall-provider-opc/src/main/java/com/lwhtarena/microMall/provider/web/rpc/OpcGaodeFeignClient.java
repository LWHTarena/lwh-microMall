package com.lwhtarena.microMall.provider.web.rpc;

import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.gaode.GaodeLocation;
import com.lwhtarena.microMall.provider.service.OpcGaodeFeignApi;
import com.lwhtarena.microMall.provider.utils.GaoDeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class Opc attachment feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RestController
@Api(value = "API - OpcGaodeFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpcGaodeFeignClient extends BaseController implements OpcGaodeFeignApi {

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据IP获取位置信息")
	public Wrapper<GaodeLocation> getLocationByIpAddr(@RequestParam("ipAddr") String ipAddr) {
		String temp = "127.0.";
		String temp2 = "192.168.";
		if (ipAddr.startsWith(temp) || ipAddr.startsWith(temp2)) {
			ipAddr = "111.199.188.14";
		}
		return WrapMapper.ok(GaoDeUtil.getCityByIpAddr(ipAddr));
	}
}
