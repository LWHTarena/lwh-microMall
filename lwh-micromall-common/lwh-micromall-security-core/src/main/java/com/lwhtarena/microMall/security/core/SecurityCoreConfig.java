package com.lwhtarena.microMall.security.core;

import com.lwhtarena.microMall.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * The class Security core config.
 *
 * @author paascloud.net@gmail.com
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
