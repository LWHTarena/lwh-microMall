package com.lwhtarena.microMall.security.app.authentication.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * The class Open id authentication security config.
 *
 * @author paascloud.net@gmail.com
 */
@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

	private final AuthenticationFailureHandler pcAuthenticationFailureHandler;

	private final SocialUserDetailsService userDetailsService;

	private final UsersConnectionRepository usersConnectionRepository;

	@Autowired
	public OpenIdAuthenticationSecurityConfig(AuthenticationSuccessHandler pcAuthenticationSuccessHandler, AuthenticationFailureHandler pcAuthenticationFailureHandler, SocialUserDetailsService userDetailsService, UsersConnectionRepository usersConnectionRepository) {
		this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
		this.pcAuthenticationFailureHandler = pcAuthenticationFailureHandler;
		this.userDetailsService = userDetailsService;
		this.usersConnectionRepository = usersConnectionRepository;
	}

	/**
	 * Configure.
	 *
	 * @param http the http
	 */
	@Override
	public void configure(HttpSecurity http) {

		OpenIdAuthenticationFilter openIdAuthenticationFilter = new OpenIdAuthenticationFilter();
		openIdAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		openIdAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
		openIdAuthenticationFilter.setAuthenticationFailureHandler(pcAuthenticationFailureHandler);

		OpenIdAuthenticationProvider openIdAuthenticationProvider = new OpenIdAuthenticationProvider();
		openIdAuthenticationProvider.setUserDetailsService(userDetailsService);
		openIdAuthenticationProvider.setUsersConnectionRepository(usersConnectionRepository);

		http.authenticationProvider(openIdAuthenticationProvider)
				.addFilterAfter(openIdAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
