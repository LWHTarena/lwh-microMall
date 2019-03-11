package com.lwhtarena.microMall.provider.mapper;


import com.lwhtarena.microMall.common.core.mybatis.MyMapper;
import com.lwhtarena.microMall.provider.model.domain.MdcProductCategory;
import com.lwhtarena.microMall.provider.model.vo.MdcCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Mdc product category mapper.
 *
 * @author paascloud.net @gmail.com
 */
@Mapper
@Component
public interface MdcProductCategoryMapper extends MyMapper<MdcProductCategory> {
	/**
	 * Select category dto list list.
	 *
	 * @param categoryPid the category pid
	 *
	 * @return the list
	 */
	List<ProductCategoryDto> selectCategoryDtoList(Long categoryPid);

	/**
	 * List category vo list.
	 *
	 * @return the list
	 */
	List<MdcCategoryVo> listCategoryVo();
}