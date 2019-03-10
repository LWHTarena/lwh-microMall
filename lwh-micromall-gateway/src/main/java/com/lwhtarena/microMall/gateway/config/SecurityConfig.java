package com.lwhtarena.microMall.gateway.config;

import org.springframework.context.annotation.Configuration;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/10 22:29
 **/

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configure.
     *
     * @param http the http
     *
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();


    }
}
