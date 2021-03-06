/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：EmailController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.lwhtarena.microMall.provider.web.mall;

import com.lwhtarena.microMall.common.base.dto.LoginAuthDto;
import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.dto.email.SendEmailMessage;
import com.lwhtarena.microMall.provider.service.EmailService;
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
 * The class Email controller.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - EmailController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController extends BaseController {

	@Resource
	private EmailService emailService;

	/**
	 * 发送短信验证码.
	 *
	 * @param sendEmailMessage the send email message
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/sendRestEmailCode")
	@ApiOperation(httpMethod = "POST", value = "发送注册短信验证码")
	public Wrapper<String> sendRestEmailCode(@RequestBody SendEmailMessage sendEmailMessage) {
		LoginAuthDto loginAuthDto = this.getLoginAuthDto();
		emailService.sendEmailCode(sendEmailMessage, loginAuthDto.getLoginName());
		return WrapMapper.ok();
	}

	/**
	 * 校验短信验证码.
	 *
	 * @param sendEmailMessage the send email message
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkRestEmailCode")
	@ApiOperation(httpMethod = "POST", value = "校验充值密码邮件验证码")
	public Wrapper checkRestEmailCode(@ApiParam(value = "验证信息") @RequestBody SendEmailMessage sendEmailMessage) {
		logger.info("校验短信验证码, checkRestEmailCode={}", sendEmailMessage);
		LoginAuthDto loginAuthDto = this.getLoginAuthDto();
		emailService.checkEmailCode(sendEmailMessage, loginAuthDto.getLoginName());
		return WrapMapper.ok();
	}
}
