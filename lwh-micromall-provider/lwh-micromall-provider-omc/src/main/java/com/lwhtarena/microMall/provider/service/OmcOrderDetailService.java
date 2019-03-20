package com.lwhtarena.microMall.provider.service;


import com.lwhtarena.microMall.common.core.support.IService;
import com.lwhtarena.microMall.provider.model.domain.OmcOrderDetail;

import java.util.List;

/**
 * The interface Omc order detail service.
 *
 * @author paascloud.net@gmail.com
 */
public interface OmcOrderDetailService extends IService<OmcOrderDetail> {
	/**
	 * 获取用户订单详情.
	 *
	 * @param orderNo the order no
	 * @param userId  the user id
	 *
	 * @return the list by order no user id
	 */
	List<OmcOrderDetail> getListByOrderNoUserId(String orderNo, Long userId);

	/**
	 * Gets list by order no.
	 *
	 * @param orderNo the order no
	 *
	 * @return the list by order no
	 */
	List<OmcOrderDetail> getListByOrderNo(String orderNo);

	/**
	 * Batch insert order detail.
	 *
	 * @param omcOrderDetailList the omc order detail list
	 */
	void batchInsertOrderDetail(List<OmcOrderDetail> omcOrderDetailList);
}