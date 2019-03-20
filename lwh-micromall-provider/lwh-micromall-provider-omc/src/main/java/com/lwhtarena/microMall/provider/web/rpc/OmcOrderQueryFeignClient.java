package com.lwhtarena.microMall.provider.web.rpc;

import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.OrderDto;
import com.lwhtarena.microMall.provider.service.OmcOrderQueryFeignApi;
import com.lwhtarena.microMall.provider.service.OmcOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Omc order query feign client.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - OmcOrderQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderQueryFeignClient extends BaseController implements OmcOrderQueryFeignApi {
	@Resource
	private OmcOrderService omcOrderService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据订单号查询订单信息")
	public Wrapper<OrderDto> queryByOrderNo(@PathVariable("orderNo") String orderNo) {
		logger.info("selectByOrderNo - 根据订单号查询订单信息. orderNo={}", orderNo);
		OrderDto orderDto = omcOrderService.queryOrderDtoByOrderNo(orderNo);
		return WrapMapper.ok(orderDto);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据订单号查询用户订单信息")
	public Wrapper<OrderDto> queryByUserIdAndOrderNo(@PathVariable("userId") Long userId, @PathVariable("orderNo") String orderNo) {
		logger.info("selectByUserIdAndOrderNo - 根据订单号查询用户订单信息. userId={}, orderNo={}", userId, orderNo);
		OrderDto orderDto = omcOrderService.queryOrderDtoByUserIdAndOrderNo(userId, orderNo);
		return WrapMapper.ok(orderDto);
	}
}
