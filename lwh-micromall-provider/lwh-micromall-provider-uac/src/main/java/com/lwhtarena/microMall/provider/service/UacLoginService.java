package com.lwhtarena.microMall.provider.service;


import com.lwhtarena.microMall.provider.model.dto.user.LoginRespDto;

/**
 * The interface Uac login service.
 *
 * @author paascloud.net@gmail.com
 */
public interface UacLoginService {

	/**
	 * Login after login resp dto.
	 *
	 * @param applicationId the application id
	 *
	 * @return the login resp dto
	 */
	LoginRespDto loginAfter(Long applicationId);

}
