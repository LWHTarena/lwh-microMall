package com.lwhtarena.microMall.provider.web.frontend;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.domain.MdcProduct;
import com.lwhtarena.microMall.provider.model.vo.ProductVo;
import com.lwhtarena.microMall.provider.service.MdcProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mdc dict main controller.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MdcProductMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcProductMainController extends BaseController {

	@Resource
	private MdcProductService mdcProductService;

	/**
	 * 分页查询商品列表.
	 *
	 * @param mdcProduct the mdc product
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryProductListWithPage")
	@ApiOperation(httpMethod = "POST", value = "分页查询商品列表")
	public Wrapper<PageInfo<ProductVo>> queryProductListWithPage(@ApiParam(name = "mdcProduct", value = "商品信息") @RequestBody MdcProduct mdcProduct) {

		logger.info("分页查询商品列表, mdcProduct={}", mdcProduct);
		PageHelper.startPage(mdcProduct.getPageNum(), mdcProduct.getPageSize());
		mdcProduct.setOrderBy("update_time desc");
		List<ProductVo> roleVoList = mdcProductService.queryProductListWithPage(mdcProduct);
		return WrapMapper.ok(new PageInfo<>(roleVoList));
	}

	/**
	 * 商品详情.
	 */
	@PostMapping(value = "/getById/{id}")
	@ApiOperation(httpMethod = "POST", value = "分页查询商品列表")
	public Wrapper<ProductVo> getById(@PathVariable Long id) {
		logger.info("查询商品详情, id={}", id);
		ProductVo productVo = mdcProductService.getProductVo(id);
		return WrapMapper.ok(productVo);
	}

	@PostMapping(value = "/save")
	@ApiOperation(httpMethod = "POST", value = "编辑商品")
	@LogAnnotation
	public Wrapper saveCategory(@RequestBody MdcEditProductDto mdcCategoryAddDto) {
		logger.info("编辑商品. mdcCategoryAddDto={}", mdcCategoryAddDto);
		mdcProductService.saveProduct(mdcCategoryAddDto, getLoginAuthDto());
		return WrapMapper.ok();
	}

	@PostMapping(value = "/deleteProductById/{id}")
	@ApiOperation(httpMethod = "POST", value = "删除商品信息")
	@LogAnnotation
	public Wrapper<ProductVo> deleteProductById(@PathVariable Long id) {
		logger.info("删除商品信息, id={}", id);
		mdcProductService.deleteProductById(id);
		return WrapMapper.ok();
	}
}
