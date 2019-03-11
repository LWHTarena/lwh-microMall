package com.lwhtarena.microMall.provider.model.domain;

import com.lwhtarena.microMall.common.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * The class Mdc product.
 *
 * @author paascloud.net@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "pc_mdc_product")
@Alias(value = "mdcProduct")
public class MdcProduct extends BaseEntity {

	private static final long serialVersionUID = 2051481072581512778L;
	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品编码
	 */
	@Column(name = "product_code")
	private String productCode;

	@Column(name = "category_id")
	private Long categoryId;

	/**
	 * 商品副标题
	 */
	private String subtitle;

	/**
	 * 产品主图,url相对地址
	 */
	@Column(name = "main_image")
	private String mainImage;

	/**
	 * 价格,单位-元保留两位小数
	 */
	private BigDecimal price;

	/**
	 * 库存数量
	 */
	private Integer stock;

	/**
	 * 商品状态.1-在售 2-下架 3-删除
	 */
	private Integer status;

	/**
	 * 图片地址,json格式,扩展用
	 */
	@Column(name = "sub_images")
	private String subImages;

	/**
	 * 商品详情
	 */
	private String detail;
}