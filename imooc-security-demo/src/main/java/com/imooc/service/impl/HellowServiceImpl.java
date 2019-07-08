/**
 * 
 */
package com.imooc.service.impl;

import org.springframework.stereotype.Service;

import com.imooc.service.HelloService;

/**
 * @author linhaifeng1
 *
 */

@Service
public class HellowServiceImpl implements HelloService {

	@Override
	public String greeting(String name) {
		System.out.println("Greeting");
		return "Hello " + name;
	}

}
