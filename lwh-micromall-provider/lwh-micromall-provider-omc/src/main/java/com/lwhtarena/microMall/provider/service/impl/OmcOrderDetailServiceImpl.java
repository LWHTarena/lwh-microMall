package com.lwhtarena.microMall.provider.service.impl;

import com.google.common.base.Preconditions;
import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.core.support.BaseService;
import com.lwhtarena.microMall.provider.exceptions.OmcBizException;
import com.lwhtarena.microMall.provider.mapper.OmcOrderDetailMapper;
import com.lwhtarena.microMall.provider.model.domain.OmcOrderDetail;
import com.lwhtarena.microMall.provider.service.OmcOrderDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Omc order detail service.
 *
 * @author paascloud.net@gmail.com
 */
@Service
public class OmcOrderDetailServiceImpl extends BaseService<OmcOrderDetail> implements OmcOrderDetailService {
	@Resource
	private OmcOrderDetailMapper omcOrderDetailMapper;

	@Override
	public List<OmcOrderDetail> getListByOrderNoUserId(String orderNo, Long userId) {
		Preconditions.checkArgument(userId != null, ErrorCodeEnum.UAC10011001.msg());
		Preconditions.checkArgument(StringUtils.isNotEmpty(orderNo), "订单号不能为空");

		return omcOrderDetailMapper.getListByOrderNoUserId(orderNo, userId);
	}

	@Override
	public List<OmcOrderDetail> getListByOrderNo(String orderNo) {
		Preconditions.checkArgument(StringUtils.isNotEmpty(orderNo), "订单号不能为空");
		return omcOrderDetailMapper.getListByOrderNo(orderNo);
	}

	@Override
	public void batchInsertOrderDetail(List<OmcOrderDetail> omcOrderDetailList) {
		int insertResult = omcOrderDetailMapper.batchInsertOrderDetail(omcOrderDetailList);
		if (insertResult < omcOrderDetailList.size()) {
			throw new OmcBizException(ErrorCodeEnum.OMC10031009);
		}
	}
}