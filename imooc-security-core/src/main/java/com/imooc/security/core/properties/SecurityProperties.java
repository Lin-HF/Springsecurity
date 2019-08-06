/**
 * 
 */
package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author linhaifeng1
 *
 */
@ConfigurationProperties(prefix = "imooc.security") //读取配置文件中所有以prefix开头的配置
public class SecurityProperties {

	BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	
	
}
