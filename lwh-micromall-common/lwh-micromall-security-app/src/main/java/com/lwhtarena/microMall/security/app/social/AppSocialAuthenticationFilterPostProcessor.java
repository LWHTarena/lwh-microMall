package com.lwhtarena.microMall.security.app.social;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type App social authentication filter post processor.
 * @author paascloud
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor{

	private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

	@Autowired
	public AppSocialAuthenticationFilterPostProcessor(AuthenticationSuccessHandler pcAuthenticationSuccessHandler) {
		this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
	}

	@Override
	public void process(final SocialAuthenticationFilter socialAuthenticationFilter) {
		socialAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
	}
}
