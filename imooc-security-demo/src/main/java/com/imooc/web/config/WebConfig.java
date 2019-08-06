/**
 * 
 */
package com.imooc.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;

/** 
 * @author linhaifeng1
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private TimeInterceptor timeInterceptor; 
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureAsyncSupport(configurer);
		//configurer.registerCallableInterceptors(interceptor);
		//configurer.registerDeferredResultInterceptors(interceptor);
		//configurer.setDefaultTimeout(timeout);
		//configurer.setTaskExecutor(taskExecutor);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addInterceptor(timeInterceptor);
	}
//	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*"); //对所有路径起作用
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}
}
