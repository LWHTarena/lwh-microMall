package com.lwhtarena.microMall.provider.web.admin;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.log.UacLogMainDto;
import com.lwhtarena.microMall.provider.service.UacLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志管理.
 *
 * @author paascloud.net@gmail.com
 */
@RestController
@RequestMapping(value = "/log", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacLogMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacLogMainController extends BaseController {
	@Resource
	private UacLogService uacLogService;

	/**
	 * 查询日志列表.
	 *
	 * @param uacLogQueryDtoPage the uac log query dto page
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryListWithPage")
	@ApiOperation(httpMethod = "POST", value = "查询日志列表")
	public Wrapper queryLogListWithPage(@ApiParam(name = "uacLogQueryDtoPage", value = "日志查询条件") @RequestBody UacLogMainDto uacLogQueryDtoPage) {
		logger.info("查询日志处理列表 uacLogQueryDtoPage={}", uacLogQueryDtoPage);
		PageInfo pageInfo = uacLogService.queryLogListWithPage(uacLogQueryDtoPage);
		return WrapMapper.ok(pageInfo);
	}
}