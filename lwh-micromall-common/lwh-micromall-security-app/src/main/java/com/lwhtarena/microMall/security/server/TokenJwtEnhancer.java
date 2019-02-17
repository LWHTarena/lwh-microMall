package com.lwhtarena.microMall.security.server;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.HashMap;
import java.util.Map;


/**
 * The class Token jwt enhancer.
 *
 * @author paascloud.net @gmail.com
 */
public class TokenJwtEnhancer implements TokenEnhancer {

	/**
	 * Enhance o auth 2 access token.
	 *
	 * @param accessToken          the access token
	 * @param oAuth2Authentication the o auth 2 authentication
	 *
	 * @return the o auth 2 access token
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oAuth2Authentication) {
		Map<String, Object> info = new HashMap<>(8);
		info.put("timestamp", System.currentTimeMillis());
		Authentication authentication = oAuth2Authentication.getUserAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			Object principal = authentication.getPrincipal();
			info.put("loginName", ((UserDetails) principal).getUsername());
		}

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		return accessToken;
	}

}
