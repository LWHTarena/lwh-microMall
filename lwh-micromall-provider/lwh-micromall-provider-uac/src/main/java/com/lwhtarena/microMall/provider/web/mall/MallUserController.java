package com.lwhtarena.microMall.provider.web.mall;

import com.lwhtarena.microMall.common.base.dto.LoginAuthDto;
import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.domain.UacUser;
import com.lwhtarena.microMall.provider.model.dto.user.UserInfoDto;
import com.lwhtarena.microMall.provider.service.UacUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Mall user controller.
 *
 * @author paascloud.net@gmail.com
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MallUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MallUserController extends BaseController {
	@Resource
	private UacUserService uacUserService;

	/**
	 * 更新用户信息.
	 *
	 * @param userInfoDto the user info dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/updateInformation")
	@ApiOperation(httpMethod = "POST", value = "更新用户信息")
	public Wrapper<UserInfoDto> updateInformation(@RequestBody UserInfoDto userInfoDto) {
		logger.info("updateInformation - 更新用户基本信息 userInfoDto={}", userInfoDto);
		UacUser uacUser = new ModelMapper().map(userInfoDto, UacUser.class);
		uacUserService.updateUser(uacUser);
		return WrapMapper.ok();
	}

	/**
	 * 获取用户信息.
	 *
	 * @return the information
	 */
	@PostMapping(value = "/getInformation")
	@ApiOperation(httpMethod = "POST", value = "获取用户信息")
	public Wrapper<UserInfoDto> getInformation() {
		LoginAuthDto loginAuthDto = getLoginAuthDto();
		Long userId = loginAuthDto.getUserId();
		logger.info("queryUserInfo - 查询用户基本信息 userId={}", userId);
		UacUser uacUser = uacUserService.queryByUserId(userId);
		if (uacUser == null) {
			return WrapMapper.error("找不到当前用户");
		}
		UserInfoDto userInfoDto = new UserInfoDto();
		BeanUtils.copyProperties(uacUser, userInfoDto);

		return WrapMapper.ok(userInfoDto);
	}
}
