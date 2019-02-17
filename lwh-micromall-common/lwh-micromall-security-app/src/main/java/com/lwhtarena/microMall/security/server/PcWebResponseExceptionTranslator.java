package com.lwhtarena.microMall.security.server;

/**
 * The class Pc web response exception translator.
 *
 * @author paascloud.net @gmail.com
 */
public class PcWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
	/**
	 * Translate response entity.
	 *
	 * @param e the e
	 *
	 * @return the response entity
	 *
	 * @throws Exception the exception
	 */
	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		return null;
	}
}
