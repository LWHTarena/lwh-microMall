package com.lwhtarena.microMall.provider.service.impl;

import com.lwhtarena.microMall.common.base.constant.GlobalConstant;
import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.exceptions.MdcBizException;
import com.lwhtarena.microMall.provider.model.dto.gaode.GaodeLocation;
import com.lwhtarena.microMall.provider.service.OpcGaodeFeignApi;
import com.lwhtarena.microMall.provider.service.OpcRpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * The class Opc rpc service.
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@Service
public class OpcRpcServiceImpl implements OpcRpcService {
	@Resource
	private OpcGaodeFeignApi opcGaodeFeignApi;

	@Override
	public String getLocationById(String addressId) {
		try {
			Wrapper<GaodeLocation> wrapper = opcGaodeFeignApi.getLocationByIpAddr(addressId);
			if (wrapper == null) {
				throw new MdcBizException(ErrorCodeEnum.GL99990002);
			}
			if (wrapper.error()) {
				throw new MdcBizException(ErrorCodeEnum.MDC10021002);
			}

			GaodeLocation result = wrapper.getResult();

			assert result != null;
			return result.getProvince().contains("市") ? result.getCity() : result.getProvince() + GlobalConstant.Symbol.SHORT_LINE + result.getCity();
		} catch (Exception e) {
			log.error("getLocationById={}", e.getMessage(), e);
		}
		return null;
	}
}
