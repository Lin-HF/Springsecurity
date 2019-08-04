/**
 * 
 */
package com.imooc.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author linhaifeng1
 *
 */
//@Component
//Component加到项目中去, 不用Component可以用WebConfig
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Time filter init");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Time filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response); //请求下一个过滤器
		System.out.println("Time filter 耗时:" + (new Date().getTime() - start));
		System.out.println("Time filter finish");

	}

	@Override
	public void destroy() {
		System.out.println("Time filter destroy");
	}

}
