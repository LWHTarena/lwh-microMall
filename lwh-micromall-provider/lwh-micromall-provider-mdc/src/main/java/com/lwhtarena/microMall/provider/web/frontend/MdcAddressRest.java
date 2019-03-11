package com.lwhtarena.microMall.provider.web.frontend;


import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.TreeNode;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.service.MdcAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mdc address rest.
 *
 * @author paascloud.net@gmail.com
 */
@RestController
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MdcAddressRest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcAddressRest extends BaseController {

	@Resource
	private MdcAddressService mdcAddressService;


	/**
	 * Gets 4 city.
	 *
	 * @return the 4 city
	 */
	@PostMapping(value = "/get4City")
	@ApiOperation(httpMethod = "POST", value = "查看四级地址")
	public Wrapper<List<TreeNode>> get4City() {
		logger.info("get4City - 获取四级地址");
		List<TreeNode> treeNodeList = mdcAddressService.get4City();
		return WrapMapper.ok(treeNodeList);
	}

}
