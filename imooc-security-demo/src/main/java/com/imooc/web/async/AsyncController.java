/**
 * 
 */
package com.imooc.web.async;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author linhaifeng1
 *
 */
@RestController
public class AsyncController {
	
	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/order")
	public DeferredResult<String> order() throws Exception {
		logger.info("主线程开始");
		
		//生成8位随机数订单号
		String orderNumberString = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumberString);
		
		DeferredResult<String> result = new DeferredResult<String>();
		deferredResultHolder.getMap().put(orderNumberString, result);

		logger.info("主线程返回");
		return result;
	}
}
