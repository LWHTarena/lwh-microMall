package com.lwhtarena.microMall.provider.model.dto;

import com.lwhtarena.microMall.common.base.dto.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Order page query.
 *
 * @author paascloud.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderPageQuery extends BaseQuery {
	private static final long serialVersionUID = -7997684399705866704L;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 订单号
	 */
	private String orderNo;
}
