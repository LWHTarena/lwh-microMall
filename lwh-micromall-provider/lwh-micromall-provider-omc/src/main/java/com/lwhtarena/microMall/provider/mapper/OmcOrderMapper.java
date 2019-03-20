package com.lwhtarena.microMall.provider.mapper;

import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.OmcOrder;
import com.lwhtarena.microMall.provider.model.dto.OrderPageQuery;
import com.lwhtarena.microMall.provider.model.vo.OrderDocVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Omc order mapper.
 *
 * @author paascloud.net @gmail.com
 */
@Mapper
@Component
public interface OmcOrderMapper extends MyMapper<OmcOrder> {
	/**
	 * Select by user id and order no omc order.
	 *
	 * @param userId  the user id
	 * @param orderNo the order no
	 *
	 * @return the omc order
	 */
	OmcOrder selectByUserIdAndOrderNo(@Param("userId") Long userId, @Param("orderNo") String orderNo);

	/**
	 * Select by order no omc order.
	 *
	 * @param orderNo the order no
	 *
	 * @return the omc order
	 */
	OmcOrder selectByOrderNo(String orderNo);

	/**
	 * Select by user id list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<OmcOrder> selectByUserId(Long userId);

	/**
	 * Select all order list.
	 *
	 * @return the list
	 */
	List<OmcOrder> selectAllOrder();

	/**
	 * Query order list with page list.
	 *
	 * @param orderPageQuery the order page query
	 *
	 * @return the list
	 */
	List<OrderDocVo> queryOrderListWithPage(OrderPageQuery orderPageQuery);
}