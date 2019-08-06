/**
 * 
 */
package com.imooc.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.imooc.security.core.properties.SecurityProperties;

/**
 * @author linhaifeng1
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
