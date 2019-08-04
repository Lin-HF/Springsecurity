/**
 * 
 */
package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author linhaifeng1
 *
 */
@Component
public class MockQueue {

	private String placeOrder;
	
	private String completeOrderString;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws Exception {
		//模拟其他应用中运行
		new Thread(()->{
			logger.info("接到下单请求， " + placeOrder);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.completeOrderString = placeOrder;
			logger.info("下单请求处理完毕， " + placeOrder);
		}).start();
	}

	public String getCompleteOrderString() {
		return completeOrderString;
	}

	public void setCompleteOrderString(String completeOrderString) {
		this.completeOrderString = completeOrderString;
	}
	
	
}
